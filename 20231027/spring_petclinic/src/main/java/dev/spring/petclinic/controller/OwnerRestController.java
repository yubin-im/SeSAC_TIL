package dev.spring.petclinic.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import dev.spring.petclinic.dto.OwnerReponse;
import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

// owner에 대한 처리 컨트롤러이기 때문에 owner 경로의 하위 요청을 올 경우 모두 수행하도록
@RequestMapping("/api/owners")  // localhost:8080/owners 로 오는 모든 요청을 받는다.
@RestController  // @Controller + @ResponseBody
@RequiredArgsConstructor
public class OwnerRestController {

    private final OwnerService ownerService;

    // GET: localhost:8080/owners - 전체 Owner 목록 조회 요청
    @GetMapping
    public List<Owner> listOwners(HttpServletResponse response) {
        // service.findAll() 호출 및 반환
        List<Owner> owners = ownerService.findAll();

        List<OwnerReponse> ownerList = owners.stream()
                .map(OwnerReponse::from)
                .collect(Collectors.toList());

        System.out.println(ownerList);
        return null;
    }

    // Owner 등록 처리, 별도의 요청 객체 처리용 DTO를 활용해서 유효성 처리, 해당 메서드의 반환 타입은 ResponseEntity 사용해보기
    // -> Postman or TalendAPI Testing(chrome Extension)



//    // 커스텀 직렬화를 사용하는 방법
//    public static class OwnerSerializer extends JsonSerializer<Owner> {
//        @Override
//        public void serialize(Owner owner, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("id", String.valueOf(owner.getId()));
//            jsonGenerator.writeStringField("firstName", owner.getFirstName());
//            jsonGenerator.writeStringField("lastName", owner.getLastName());
//            jsonGenerator.writeStringField("address", owner.getAddress());
//            jsonGenerator.writeStringField("city", owner.getCity());
//            jsonGenerator.writeStringField("telephone", owner.getTelephone());
//            // sonGenerator.writeStringField("pets", String.valueOf(owner.getPets()));
//            jsonGenerator.writeEndObject();
//        }
//    }

}
