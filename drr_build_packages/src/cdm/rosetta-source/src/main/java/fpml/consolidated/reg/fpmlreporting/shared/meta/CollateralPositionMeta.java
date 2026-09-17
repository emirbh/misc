package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPosition;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPositionTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPositionValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.datarule.CollateralPositionChoice;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.CollateralPositionOnlyExistsValidator;
import fpml.consolidated.repo.SecurityValuation;
import fpml.consolidated.repo.validation.datarule.SecurityValuationChoice0;
import fpml.consolidated.repo.validation.datarule.SecurityValuationChoice1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralPosition.class)
public class CollateralPositionMeta implements RosettaMetaData<CollateralPosition> {

	@Override
	public List<Validator<? super CollateralPosition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecurityValuation>create(SecurityValuationChoice0.class),
			factory.<SecurityValuation>create(SecurityValuationChoice1.class),
			factory.<CollateralPosition>create(CollateralPositionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralPosition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralPosition> validator(ValidatorFactory factory) {
		return factory.<CollateralPosition>create(CollateralPositionValidator.class);
	}

	@Override
	public Validator<? super CollateralPosition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralPosition>create(CollateralPositionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPosition> validator() {
		return new CollateralPositionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPosition> typeFormatValidator() {
		return new CollateralPositionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralPosition, Set<String>> onlyExistsValidator() {
		return new CollateralPositionOnlyExistsValidator();
	}
}
