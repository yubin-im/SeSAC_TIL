package dev.spring.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner save(Owner owner) {

        Owner result = ownerRepository.save(owner);
        System.out.println(result);
        // DB 등록 처리 로직 구현
        return ownerRepository.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        // JPA - manager.find(Owner.class, 1);

        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (optionalOwner.isPresent()) { // optional 내부의 값이 유효하면
            return optionalOwner.get(); // optional 내부에서 해당 객체를 꺼냄
        } else {
            // 예외 던지기
            return null;
        }
        // 한줄로 표현
        // ownerRepository.findById(id).orElse(null); // orElseThrow(람다 형태) 활용 권장
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

}
