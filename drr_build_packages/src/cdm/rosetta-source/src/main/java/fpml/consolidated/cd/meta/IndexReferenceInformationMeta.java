package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.cd.validation.IndexReferenceInformationTypeFormatValidator;
import fpml.consolidated.cd.validation.IndexReferenceInformationValidator;
import fpml.consolidated.cd.validation.exists.IndexReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IndexReferenceInformation.class)
public class IndexReferenceInformationMeta implements RosettaMetaData<IndexReferenceInformation> {

	@Override
	public List<Validator<? super IndexReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndexReferenceInformation> validator(ValidatorFactory factory) {
		return factory.<IndexReferenceInformation>create(IndexReferenceInformationValidator.class);
	}

	@Override
	public Validator<? super IndexReferenceInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndexReferenceInformation>create(IndexReferenceInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndexReferenceInformation> validator() {
		return new IndexReferenceInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IndexReferenceInformation> typeFormatValidator() {
		return new IndexReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexReferenceInformation, Set<String>> onlyExistsValidator() {
		return new IndexReferenceInformationOnlyExistsValidator();
	}
}
