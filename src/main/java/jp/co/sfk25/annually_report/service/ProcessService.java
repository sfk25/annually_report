package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.domain.repository.ProcessRepository;
import jp.co.sfk25.annually_report.domain.entity.Process;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessService {
    private final ProcessRepository processRepository;

    public List<Process> getProcesses() {
        return processRepository.findAll();
    }
}
