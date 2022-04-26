package com.example.winter2022jspday4jpaexample;

import com.example.model.State;
import com.example.model.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Type;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Path("/provincesAndStates")
public class ProvinceAndStateResource {
    @Context
    private HttpServletResponse response;

    @GET
    @Path("/getProvinces")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProvinces() {
        try {
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Class.forName ("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from Province a");
        List<Province> list = query.getResultList();

        Gson gson = new Gson();
        Type type = new TypeToken<List<Province>>() {
        }.getType();
        entityManager.close();
        return gson.toJson(list, type);
    }

    @GET
    @Path("/getStates")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStates() {
        try {
            Class.forName ("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from State a");
        List<State> list = query.getResultList();

        Gson gson = new Gson();
        Type type = new TypeToken<List<State>>() {
        }.getType();
        entityManager.close();
        return gson.toJson(list, type);
    }

    //@GET
    //@Path("/getagent/{agentId}")
    //@Produces(MediaType.APPLICATION_JSON)
    //public String getAgent(@PathParam("agentId") int agentId) {
    //    try {
    //        Class.forName ("org.mariadb.jdbc.Driver");
    //    } catch (ClassNotFoundException e) {
    //        e.printStackTrace();
    //    }
    //    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    //    EntityManager entityManager = entityManagerFactory.createEntityManager();
    //    Agent agent = entityManager.find(Agent.class, agentId);
//
    //    Gson gson = new Gson();
    //    entityManager.close();
    //    return gson.toJson(agent);
    //}

   // @POST
   // @Path("/postagent")
   // @Produces(MediaType.APPLICATION_JSON)
   // @Consumes({MediaType.APPLICATION_JSON})
   // public String postAgent(String jsonString) {
   //     try {
   //         Class.forName ("org.mariadb.jdbc.Driver");
   //     } catch (ClassNotFoundException e) {
   //         e.printStackTrace();
   //     }
   //     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
   //     EntityManager entityManager = entityManagerFactory.createEntityManager();
//
   //     Gson gson = new Gson();
   //     Agent agent = gson.fromJson(jsonString, Agent.class);
   //     entityManager.getTransaction().begin();
   //     Agent mergedAgent = entityManager.merge(agent);
   //     if (mergedAgent != null)
   //     {
   //         entityManager.getTransaction().commit();
   //         entityManager.close();
   //         return "{ 'message':'Update successful' }";
   //     }
   //     else
   //     {
   //         entityManager.getTransaction().rollback();
   //         entityManager.close();
   //         return "{ 'message':'Update failed' }";
   //     }
   // }

    //@PUT
    //@Path("putagent")
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes({MediaType.APPLICATION_JSON})
    //public String putAgent(String jsonString) {
    //    try {
    //        Class.forName ("org.mariadb.jdbc.Driver");
    //    } catch (ClassNotFoundException e) {
    //        e.printStackTrace();
    //    }
    //    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    //    EntityManager entityManager = entityManagerFactory.createEntityManager();
//
    //    Gson gson = new Gson();
    //    Agent agent = gson.fromJson(jsonString, Agent.class);
    //    //Agent foundAgent = entityManager.find(Agent.class, agent);
    //    //if (foundAgent == null)
    //    //{
    //        entityManager.getTransaction().begin();
    //        entityManager.persist(agent);
//  //      if (entityManager.contains(agent))
//  //      {
    //        entityManager.getTransaction().commit();
    //        entityManager.close();
    //        return "{ 'message':'Insert successful' }";
    //   // }
    //   // else
    //   // {
    //   //     entityManager.close();
    //   //     return "{ 'message':'Agent already exists' }";
    //   // }
    //}

    //@DELETE
    //@Path("/deleteagent/{ agentId }")
    //@Produces(MediaType.APPLICATION_JSON)
    //public String deleteAgent(@PathParam("agentId") int agentId) {
    //    try {
    //        Class.forName ("org.mariadb.jdbc.Driver");
    //    } catch (ClassNotFoundException e) {
    //        e.printStackTrace();
    //    }
    //    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    //    EntityManager entityManager = entityManagerFactory.createEntityManager();
//
    //    Agent agent = entityManager.find(Agent.class, agentId);
    //    entityManager.getTransaction().begin();
    //    entityManager.remove(agent);
    //    if (!entityManager.contains(agent))
    //    {
    //        entityManager.getTransaction().commit();
    //        entityManager.close();
    //        return "{ 'message':'Delete successful' }";
    //    }
    //    else
    //    {
    //        entityManager.getTransaction().rollback();
    //        entityManager.close();
    //        return "{ 'message':'Delete failed' }";
    //    }
    //}
}