package com.rasoiyya.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.RasoiyyaApiLogs;

@Repository
public interface RasoiyyaApiLogsRepositoy extends JpaRepository<RasoiyyaApiLogs, Integer> {

}
