package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.validation.EscrowArrangementTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.EscrowArrangementValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.EscrowArrangementSettlementPostponementExistence;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.EscrowArrangementOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=EscrowArrangement.class)
public class EscrowArrangementMeta implements RosettaMetaData<EscrowArrangement> {

	@Override
	public List<Validator<? super EscrowArrangement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EscrowArrangement>create(EscrowArrangementSettlementPostponementExistence.class)
		);
	}
	
	@Override
	public List<Function<? super EscrowArrangement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EscrowArrangement> validator(ValidatorFactory factory) {
		return factory.<EscrowArrangement>create(EscrowArrangementValidator.class);
	}

	@Override
	public Validator<? super EscrowArrangement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EscrowArrangement>create(EscrowArrangementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EscrowArrangement> validator() {
		return new EscrowArrangementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EscrowArrangement> typeFormatValidator() {
		return new EscrowArrangementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EscrowArrangement, Set<String>> onlyExistsValidator() {
		return new EscrowArrangementOnlyExistsValidator();
	}
}
