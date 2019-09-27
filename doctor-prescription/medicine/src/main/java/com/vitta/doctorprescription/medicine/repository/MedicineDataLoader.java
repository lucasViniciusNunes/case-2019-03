package com.vitta.doctorprescription.medicine.repository;

import com.vitta.doctorprescription.medicine.domain.MedicineEntity;
import com.vitta.doctorprescription.medicine.domain.MedicinePharmaconEntity;
import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import com.vitta.doctorprescription.pharmacon.repository.PharmaconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class MedicineDataLoader {

    // region repositories

    @Autowired
    private MedicineRepository repository;

    @Autowired
    private PharmaconRepository pharmaconRepository;

    @Autowired
    private MedicinePharmaconRepository medicinePharmaconRepository;

    // endregion

    /**
     * Method invoked during the startup to insert system base data.
     */
    @PostConstruct
    @Transactional(rollbackFor = Throwable.class)
    public void loadData() {

        // Insert medicines
        MedicineEntity cloridato = repository.save(new MedicineEntity(40812L, "CLORIDRATO DE NORTRIPTILINA", "ORAL"));
        MedicineEntity pamelor = repository.save(new MedicineEntity(21058L, "PAMELOR", "ORAL"));

        MedicineEntity zolamox = repository.save(new MedicineEntity(28438L, "ZOLAMOX", "ORAL"));
        MedicineEntity diamox = repository.save(new MedicineEntity(10508L, "DIAMOX", "ORAL"));

        MedicineEntity succinato = repository.save(new MedicineEntity(26028L, "TERRA - CORTRIL", "INTRAVENOSA"));
        MedicineEntity terra = repository.save(new MedicineEntity(25171L, "SUCCINATO SODICO DE HIDROCORTISONA", "INTRAVENOSA"));

        // Insert pharmacons
        PharmaconEntity nortriptilina = pharmaconRepository.save(new PharmaconEntity("NORTRIPTILINA"));
        PharmaconEntity acetazolamida = pharmaconRepository.save(new PharmaconEntity("ACETAZOLAMIDA"));
        PharmaconEntity hidrocortisona = pharmaconRepository.save(new PharmaconEntity("HIDROCORTISONA"));
        PharmaconEntity oxitetraciclina = pharmaconRepository.save(new PharmaconEntity("OXITETRACICLINA"));

        // Insert medicine pharmacons
        medicinePharmaconRepository.save(new MedicinePharmaconEntity(cloridato, nortriptilina));
        medicinePharmaconRepository.save(new MedicinePharmaconEntity(pamelor, nortriptilina));

        medicinePharmaconRepository.save(new MedicinePharmaconEntity(zolamox, acetazolamida));
        medicinePharmaconRepository.save(new MedicinePharmaconEntity(diamox, acetazolamida));

        medicinePharmaconRepository.save(new MedicinePharmaconEntity(succinato, hidrocortisona));
        medicinePharmaconRepository.save(new MedicinePharmaconEntity(terra, hidrocortisona));
        medicinePharmaconRepository.save(new MedicinePharmaconEntity(terra, oxitetraciclina));

    }

}
