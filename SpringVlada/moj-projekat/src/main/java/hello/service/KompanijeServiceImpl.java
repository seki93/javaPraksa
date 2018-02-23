package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.repository.KompanijaRepository;


@Service
public class KompanijeServiceImpl implements KompanijeService {

	@Autowired
	KompanijaRepository kompanijeRepository;

	@Override
	@Transactional
	public void deleteById(Integer id) {
		kompanijeRepository.deleteById(id);
	}

}
