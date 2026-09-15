package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.ContactInformation;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.NaturalPersonBuyerOrSeller;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CountryAndProvinceOrTerritoryOfIndividualRule.CountryAndProvinceOrTerritoryOfIndividualRuleDefault.class)
public abstract class CountryAndProvinceOrTerritoryOfIndividualRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected NaturalPersonBuyerOrSeller naturalPersonBuyerOrSeller;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class CountryAndProvinceOrTerritoryOfIndividualRuleDefault extends CountryAndProvinceOrTerritoryOfIndividualRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<ReferenceWithMetaParty> thenArg1 = thenArg0
				.mapSingleToItem(item -> item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()));
			output = thenArg1
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty0 = item.get();
					final MapperS<Address> thenArg;
					if (exists(MapperS.of(naturalPersonBuyerOrSeller.evaluate((referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue())))).getOrDefault(false)) {
						final ReferenceWithMetaParty referenceWithMetaParty1 = item.get();
						thenArg = MapperS.of(MapperS.of(naturalPersonBuyerOrSeller.evaluate((referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()))).<ContactInformation>map("getContactInformation", naturalPerson -> naturalPerson.getContactInformation()).<Address>mapC("getAddress", contactInformation -> contactInformation.getAddress()).get());
					} else {
						thenArg = MapperS.<Address>ofNull();
					}
					return thenArg
						.mapSingleToItem(_item -> {
							if (areEqual(_item.<FieldWithMetaString>map("getCountry", address -> address.getCountry()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of("CA"), CardinalityOperator.All).getOrDefault(false)) {
								return _item.<String>map("getState", address -> address.getState());
							}
							return _item.<FieldWithMetaString>map("getCountry", address -> address.getCountry()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue());
						});
				}).get();
			
			return output;
		}
	}
}
