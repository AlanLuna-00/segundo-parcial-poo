package mvc.controller;

import mvc.dto.AutoDTO;
import mvc.model.Auto;
import mvc.model.AutoDeportivo;
import mvc.model.AutoSedan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AutoController {

    private List<Auto> autos;

    private static AutoController INSTANCE;

    private AutoController() {
        initAutos();
    }

    public synchronized static AutoController getInstance(){
        if(Objects.isNull(INSTANCE)){
            INSTANCE = new AutoController();
        }
        return INSTANCE;
    }

    public void initAutos(){
        if(Objects.isNull(autos)){
            autos = new ArrayList<>();
        }
    }

    public AutoDTO crearAuto(AutoDTO autoDTO) throws Exception {
        Optional<AutoDTO> auto = buscarAuto(autoDTO.getPatente());
        if(auto.isPresent())
            throw new Exception("Ya existe un auto con esa patente en el sistema.");
        autos.add(toModel(autoDTO));
        return autoDTO;
    }

    public Optional<AutoDTO> buscarAuto(String patente) {
        int i = 0;
        Auto auto = null;
        while (i < autos.size() && Objects.isNull(auto)) {
            if (autos.get(i).getPatente().equals(patente)) {
                auto = autos.get(i);
            }
            i++;
        }
        return Optional.ofNullable(auto).map(AutoController::toDTO);
    }

    public List<AutoDTO> listarAutos() {
        List<AutoDTO> autosDTO = new ArrayList<>();
        autos.forEach(auto -> autosDTO.add(toDTO(auto)));
        return autosDTO;
    }


    private static Auto toModel(AutoDTO autoDTO) {
        if (Objects.nonNull(autoDTO.getPrecioAdicional())) {
            return new AutoDeportivo(
                    autoDTO.getPatente(),
                    autoDTO.getModelo(),
                    autoDTO.getCapacidad(),
                    autoDTO.getPrecioPorKm(),
                    autoDTO.getPrecioAdicional()
            );
        } else {
            return new AutoSedan(
                    autoDTO.getPatente(),
                    autoDTO.getModelo(),
                    autoDTO.getCapacidad(),
                    autoDTO.getPrecioPorKm()
            );
        }
    }

    private static AutoDTO toDTO(Auto auto) {
        if (auto instanceof AutoDeportivo autoDeportivo) {
            return new AutoDTO(
                    autoDeportivo.getPatente(),
                    autoDeportivo.getModelo(),
                    autoDeportivo.getCapacidad(),
                    autoDeportivo.getPrecioPorKm(),
                    autoDeportivo.getPrecioAdicional()
            );
        } else {
            return new AutoDTO(
                    auto.getPatente(),
                    auto.getModelo(),
                    auto.getCapacidad(),
                    auto.getPrecioPorKm()
            );
        }
    }


}
