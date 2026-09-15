package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.PhysicalSettlement;
import fpml.consolidated.business.events.validation.PhysicalSettlementTypeFormatValidator;
import fpml.consolidated.business.events.validation.PhysicalSettlementValidator;
import fpml.consolidated.business.events.validation.datarule.PhysicalSettlementChoice;
import fpml.consolidated.business.events.validation.exists.PhysicalSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PhysicalSettlement.class)
public class PhysicalSettlementMeta implements RosettaMetaData<PhysicalSettlement> {

	@Override
	public List<Validator<? super PhysicalSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PhysicalSettlement>create(PhysicalSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PhysicalSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PhysicalSettlement> validator(ValidatorFactory factory) {
		return factory.<PhysicalSettlement>create(PhysicalSettlementValidator.class);
	}

	@Override
	public Validator<? super PhysicalSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PhysicalSettlement>create(PhysicalSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSettlement> validator() {
		return new PhysicalSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSettlement> typeFormatValidator() {
		return new PhysicalSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalSettlement, Set<String>> onlyExistsValidator() {
		return new PhysicalSettlementOnlyExistsValidator();
	}
}
