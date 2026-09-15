package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ReferenceBank;
import fpml.consolidated.shared.validation.ReferenceBankTypeFormatValidator;
import fpml.consolidated.shared.validation.ReferenceBankValidator;
import fpml.consolidated.shared.validation.exists.ReferenceBankOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferenceBank.class)
public class ReferenceBankMeta implements RosettaMetaData<ReferenceBank> {

	@Override
	public List<Validator<? super ReferenceBank>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceBank, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceBank> validator(ValidatorFactory factory) {
		return factory.<ReferenceBank>create(ReferenceBankValidator.class);
	}

	@Override
	public Validator<? super ReferenceBank> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferenceBank>create(ReferenceBankTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceBank> validator() {
		return new ReferenceBankValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceBank> typeFormatValidator() {
		return new ReferenceBankTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceBank, Set<String>> onlyExistsValidator() {
		return new ReferenceBankOnlyExistsValidator();
	}
}
