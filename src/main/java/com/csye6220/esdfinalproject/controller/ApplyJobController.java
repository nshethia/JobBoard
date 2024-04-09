package com.csye6220.esdfinalproject.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.csye6220.esdfinalproject.model.ApplyJob;
import com.csye6220.esdfinalproject.model.JobPost;
import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.service.ApplyJobService;
import com.csye6220.esdfinalproject.service.JobPostService;
import com.csye6220.esdfinalproject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ApplyJobController {

	@Autowired
	ApplyJobService applyJobService;
	@Autowired
	JobPostService jobPostService;
	@Autowired
	UserService userService;

	@GetMapping("/apply")
	public String applyForJob(@RequestParam("id") Long jobId, Model model, HttpSession session,
			HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			model.addAttribute("userEmail", user.getEmail());
		}
		JobPost job = jobPostService.getJobById(jobId);

		
		if (job != null) {
			model.addAttribute("job", job.getJobId());
		}
		
		return "apply_job";
	}

	@PostMapping("/apply/{jobId}")
	public String showSuccessFormPostHandler(@PathVariable Long jobId, @ModelAttribute ApplyJob applyJob,
			BindingResult result, @RequestParam("resume") MultipartFile resumeFile,
			@RequestParam("documents") MultipartFile documentsFile) {

		if (result.hasErrors()) {
			return "apply_job";
		}

		JobPost jobPost = jobPostService.getJobById(jobId);
		applyJob.setJobPost(jobPost);
		applyJobService.save(applyJob);

		try {

			String homeDirectory = System.getProperty("user.home");

			File resume = new File(homeDirectory + "/Resumes_applicants/" + applyJob.getId() + "_resume.pdf");
			if (resumeFile != null && !resumeFile.isEmpty()) {
				resume.createNewFile();
				applyJob.setResumePath(resume.getAbsolutePath());
				applyJob.getResume().transferTo(resume);
			}

			File documents = new File(homeDirectory + "/Documents_applicants/" + applyJob.getId() + "_docs.pdf");
			if (documentsFile != null && !documentsFile.isEmpty()) {
				documents.createNewFile();
				applyJob.getDocuments().transferTo(documents);
				applyJob.setDocumentsPath(documents.getAbsolutePath());
			}

			applyJobService.save(applyJob);
		}

		catch (IllegalStateException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return "view-apply-success";
	}

	@GetMapping("/appliedJobs")
	public String showAppliedJobs(Model model, HttpSession session, HttpServletRequest request, String email) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			email = user.getEmail();
			List<ApplyJob> appliedJobs = applyJobService.findJobsByEmail(email);
			model.addAttribute("appliedJobs", appliedJobs);
		}

		return "applied_jobs";
	}

}
