package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.validation.PartyRelationshipTypeTypeFormatValidator;
import fpml.consolidated.doc.validation.PartyRelationshipTypeValidator;
import fpml.consolidated.doc.validation.exists.PartyRelationshipTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyRelationshipType.class)
public class PartyRelationshipTypeMeta implements RosettaMetaData<PartyRelationshipType> {

	@Override
	public List<Validator<? super PartyRelationshipType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyRelationshipType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyRelationshipType> validator(ValidatorFactory factory) {
		return factory.<PartyRelationshipType>create(PartyRelationshipTypeValidator.class);
	}

	@Override
	public Validator<? super PartyRelationshipType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyRelationshipType>create(PartyRelationshipTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyRelationshipType> validator() {
		return new PartyRelationshipTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyRelationshipType> typeFormatValidator() {
		return new PartyRelationshipTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyRelationshipType, Set<String>> onlyExistsValidator() {
		return new PartyRelationshipTypeOnlyExistsValidator();
	}
}
