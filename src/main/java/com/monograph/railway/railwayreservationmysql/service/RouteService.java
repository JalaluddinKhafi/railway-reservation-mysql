package com.monograph.railway.railwayreservationmysql.service;

import com.monograph.railway.railwayreservationmysql.model.Route;

import java.util.List;

public interface RouteService {
    Route saveRoute(Route route);
    Route getRouteById(Long id);
    List<Route> getAllRoutes();
    void deleteRoute(Long id);
}

