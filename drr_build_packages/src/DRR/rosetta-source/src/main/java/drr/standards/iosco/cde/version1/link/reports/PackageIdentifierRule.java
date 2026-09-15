package drr.standards.iosco.cde.version1.link.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.base.staticdata.identifier.Identifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.link.functions.PackageInformation;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PackageIdentifierRule.PackageIdentifierRuleDefault.class)
public abstract class PackageIdentifierRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PackageInformation packageInformation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class PackageIdentifierRuleDefault extends PackageIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperS<IdentifiedList> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(packageInformation.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(packageInformation.evaluate(item.get()));
					}
					return MapperS.<IdentifiedList>ofNull();
				});
			final MapperC<FieldWithMetaString> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<Identifier>map("getListId", identifiedList -> identifiedList.getListId()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = MapperS.of(thenArg1.get()).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
