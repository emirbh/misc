package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import fpml.consolidated.shared.validation.SwaptionPhysicalSettlementTypeFormatValidator;
import fpml.consolidated.shared.validation.SwaptionPhysicalSettlementValidator;
import fpml.consolidated.shared.validation.datarule.SwaptionPhysicalSettlementChoice;
import fpml.consolidated.shared.validation.exists.SwaptionPhysicalSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SwaptionPhysicalSettlement.class)
public class SwaptionPhysicalSettlementMeta implements RosettaMetaData<SwaptionPhysicalSettlement> {

	@Override
	public List<Validator<? super SwaptionPhysicalSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SwaptionPhysicalSettlement>create(SwaptionPhysicalSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SwaptionPhysicalSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SwaptionPhysicalSettlement> validator(ValidatorFactory factory) {
		return factory.<SwaptionPhysicalSettlement>create(SwaptionPhysicalSettlementValidator.class);
	}

	@Override
	public Validator<? super SwaptionPhysicalSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SwaptionPhysicalSettlement>create(SwaptionPhysicalSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SwaptionPhysicalSettlement> validator() {
		return new SwaptionPhysicalSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SwaptionPhysicalSettlement> typeFormatValidator() {
		return new SwaptionPhysicalSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwaptionPhysicalSettlement, Set<String>> onlyExistsValidator() {
		return new SwaptionPhysicalSettlementOnlyExistsValidator();
	}
}
