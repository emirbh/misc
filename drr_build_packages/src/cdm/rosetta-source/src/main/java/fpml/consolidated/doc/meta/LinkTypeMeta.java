package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.LinkType;
import fpml.consolidated.doc.validation.LinkTypeTypeFormatValidator;
import fpml.consolidated.doc.validation.LinkTypeValidator;
import fpml.consolidated.doc.validation.exists.LinkTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LinkType.class)
public class LinkTypeMeta implements RosettaMetaData<LinkType> {

	@Override
	public List<Validator<? super LinkType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LinkType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LinkType> validator(ValidatorFactory factory) {
		return factory.<LinkType>create(LinkTypeValidator.class);
	}

	@Override
	public Validator<? super LinkType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LinkType>create(LinkTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LinkType> validator() {
		return new LinkTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LinkType> typeFormatValidator() {
		return new LinkTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LinkType, Set<String>> onlyExistsValidator() {
		return new LinkTypeOnlyExistsValidator();
	}
}
