package com.ego.service;


import java.util.ArrayList;
import com.ego.dao.NoteDao;
import com.ego.po.Note;


public class NoteService {
	
	NoteDao dao = new NoteDao();
	
	public ArrayList<Note> getAll() {
		return dao.getAll();
	}
	

	
	public boolean insert(Note noteInfo) {
		return dao.insert(noteInfo);
	}
	
	public boolean modify(Note noteInfo) {
		return dao.modify(noteInfo);
	}
	
	public boolean delete(int noteId) {
		return dao.delete(noteId);
	}
	
	public Note getLatest() {
		return dao.getLatest();
	}

}
