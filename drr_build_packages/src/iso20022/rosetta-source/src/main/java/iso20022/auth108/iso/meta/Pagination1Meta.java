package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.Pagination1;
import iso20022.auth108.iso.validation.Pagination1TypeFormatValidator;
import iso20022.auth108.iso.validation.Pagination1Validator;
import iso20022.auth108.iso.validation.exists.Pagination1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Pagination1.class)
public class Pagination1Meta implements RosettaMetaData<Pagination1> {

	@Override
	public List<Validator<? super Pagination1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Pagination1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Pagination1> validator(ValidatorFactory factory) {
		return factory.<Pagination1>create(Pagination1Validator.class);
	}

	@Override
	public Validator<? super Pagination1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Pagination1>create(Pagination1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Pagination1> validator() {
		return new Pagination1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Pagination1> typeFormatValidator() {
		return new Pagination1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Pagination1, Set<String>> onlyExistsValidator() {
		return new Pagination1OnlyExistsValidator();
	}
}
