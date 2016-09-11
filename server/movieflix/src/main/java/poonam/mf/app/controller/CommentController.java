package poonam.mf.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poonam.mf.app.entity.Comment;
import poonam.mf.app.service.CommentService;

@RestController
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentController {
	
	@Autowired
	CommentService service;

	//Pass Parameter and value: <movieId, value>
	@RequestMapping(method = RequestMethod.GET)
	public List<Comment> findByParams(@RequestParam Map<String, String> params) {
		return service.findByParams(params);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Comment findById(@PathVariable("id") String commentId) {
		return service.findById(commentId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(@RequestBody Comment comment, @RequestParam Map<String, String> params) {
		return service.create(params, comment);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment update(@PathVariable("id") String id, @RequestBody Comment comment) {
		return service.update(id, comment);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
