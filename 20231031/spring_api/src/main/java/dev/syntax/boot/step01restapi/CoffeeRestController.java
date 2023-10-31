package dev.syntax.boot.step01restapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeRestController {
    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeRestController() {
        coffees.addAll(List.of(
                new Coffee("아메리카노"),
                new Coffee("카페라떼"),
                new Coffee("페퍼민트"),
                new Coffee("유자레몬티")
        ));
    }

    // GET: localhost:8080/coffees
    @GetMapping
    Iterable<Coffee> getCoffees() {

        return coffees;
    }

    // GET: localhost:8080/coffees/1
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for(Coffee c: coffees) {
            if(c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    Coffee addCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);

        return coffee;
    }

    // PUT 메서드 활용, pathVariable로 전달받은 id값에 해당하는 Coffee 데이터 변경
    // 2개의 파라미터 받기
    // 1. id값 2. 변경할 Coffee 객체
    @PutMapping("/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee updatedCoffee) {
        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                // 해당 id를 가진 Coffee 데이터를 찾았으므로 업데이트
                coffee.setName(updatedCoffee.getName()); // 다른 속성 수정
                return coffee;
            }
        }
        // 해당 id를 가진 Coffee 데이터를 찾지 못한 경우
        return null;
    }

    // DELETE 메서드 활용, PathVariable로 전달받은 id 값에 해당하는 Coffee 데이터 제거
    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(coffee -> coffee.getId().equals(id));
    }

}
