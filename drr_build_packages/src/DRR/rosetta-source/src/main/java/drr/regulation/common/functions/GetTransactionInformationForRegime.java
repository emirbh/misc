package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTransactionInformationForRegime.GetTransactionInformationForRegimeDefault.class)
public abstract class GetTransactionInformationForRegime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param transaction 
	* @param regime 
	* @param supervisoryBodyIn 
	* @return transactionInformation 
	*/
	public ReportableJurisdictionInformation evaluate(TransactionReportInstruction transaction, RegimeNameEnum regime, SupervisoryBodyEnum supervisoryBodyIn) {
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder transactionInformationBuilder = doEvaluate(transaction, regime, supervisoryBodyIn);
		
		final ReportableJurisdictionInformation transactionInformation;
		if (transactionInformationBuilder == null) {
			transactionInformation = null;
		} else {
			transactionInformation = transactionInformationBuilder.build();
			objectValidator.validate(ReportableJurisdictionInformation.class, transactionInformation);
		}
		
		return transactionInformation;
	}

	protected abstract ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder doEvaluate(TransactionReportInstruction transaction, RegimeNameEnum regime, SupervisoryBodyEnum supervisoryBodyIn);

	public static class GetTransactionInformationForRegimeDefault extends GetTransactionInformationForRegime {
		@Override
		protected ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder doEvaluate(TransactionReportInstruction transaction, RegimeNameEnum regime, SupervisoryBodyEnum supervisoryBodyIn) {
			ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder transactionInformation = ReportableJurisdictionInformation.builder();
			return assignOutput(transactionInformation, transaction, regime, supervisoryBodyIn);
		}
		
		protected ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder assignOutput(ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder transactionInformation, TransactionReportInstruction transaction, RegimeNameEnum regime, SupervisoryBodyEnum supervisoryBodyIn) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(regime), CardinalityOperator.All).andNullSafe(areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(supervisoryBodyIn), CardinalityOperator.All).orNullSafe(notExists(MapperS.of(supervisoryBodyIn)))).get());
			transactionInformation = toBuilder(MapperS.of(thenArg1.get()).get());
			
			return Optional.ofNullable(transactionInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
