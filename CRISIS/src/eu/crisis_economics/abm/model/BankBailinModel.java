/*
 * This file is part of CRISIS, an economics simulator.
 * 
 * Copyright (C) 2015 John Kieran Phillips
 *
 * CRISIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CRISIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CRISIS.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.crisis_economics.abm.model;

import eu.crisis_economics.abm.model.configuration.BailinBankBankruptcyPolicyConfiguration;
import eu.crisis_economics.abm.model.configuration.ChartistAndFundamentalistBankSubeconomy;
import eu.crisis_economics.abm.model.configuration.MacroeconomicFirmsSubEconomy;
import eu.crisis_economics.abm.model.configuration.MasterModelConfiguration;

/**
  * An implementation of the abstract {@link AbstractBankBankruptcyModel} model.
  * This implementation specializes the abstract class {@link AbstractBankBankruptcyModel}
  * to the bailin bankruptcy resolution case.
  * 
  * @author phillips
  */
public class BankBailinModel extends AbstractBankBankruptcyModel {
   
   public BankBailinModel() {
      super(1L);
   }
   
   public BankBailinModel(long seed) {
      super(seed);
   }
   
   @Override
   protected MasterModelConfiguration configureBankruptcyPolicy(
      MasterModelConfiguration agentsConfiguration) {
      
      final MacroeconomicFirmsSubEconomy
         firmsSubEconomy = new MacroeconomicFirmsSubEconomy();
      
      agentsConfiguration.setFirmsSubEconomy(firmsSubEconomy);
      
      final ChartistAndFundamentalistBankSubeconomy
         financialSubeconomy = new ChartistAndFundamentalistBankSubeconomy();
      
      financialSubeconomy.setBankBankruptcyResolutionPolicy(
         new BailinBankBankruptcyPolicyConfiguration());
      
      agentsConfiguration.setBankingSubEconomy(financialSubeconomy);
      
      return agentsConfiguration;
   }
   
   private static final long serialVersionUID = -9214049495217277760L;
}
