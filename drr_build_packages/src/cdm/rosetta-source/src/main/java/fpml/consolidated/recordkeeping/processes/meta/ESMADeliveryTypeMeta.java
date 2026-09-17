package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMADeliveryType;
import fpml.consolidated.recordkeeping.processes.validation.ESMADeliveryTypeTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.ESMADeliveryTypeValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.ESMADeliveryTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ESMADeliveryType.class)
public class ESMADeliveryTypeMeta implements RosettaMetaData<ESMADeliveryType> {

	@Override
	public List<Validator<? super ESMADeliveryType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ESMADeliveryType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMADeliveryType> validator(ValidatorFactory factory) {
		return factory.<ESMADeliveryType>create(ESMADeliveryTypeValidator.class);
	}

	@Override
	public Validator<? super ESMADeliveryType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMADeliveryType>create(ESMADeliveryTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMADeliveryType> validator() {
		return new ESMADeliveryTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMADeliveryType> typeFormatValidator() {
		return new ESMADeliveryTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMADeliveryType, Set<String>> onlyExistsValidator() {
		return new ESMADeliveryTypeOnlyExistsValidator();
	}
}
