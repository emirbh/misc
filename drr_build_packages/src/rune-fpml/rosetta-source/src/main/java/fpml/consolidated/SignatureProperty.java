package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.meta.SignaturePropertyMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="SignatureProperty", builder=SignatureProperty.SignaturePropertyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignatureProperty", model="fpml", builder=SignatureProperty.SignaturePropertyBuilderImpl.class, version="2.1.1")
public interface SignatureProperty extends SignaturePropertyType {

	SignaturePropertyMeta metaData = new SignaturePropertyMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureProperty build();
	
	SignatureProperty.SignaturePropertyBuilder toBuilder();
	
	static SignatureProperty.SignaturePropertyBuilder builder() {
		return new SignatureProperty.SignaturePropertyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureProperty> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignatureProperty> getType() {
		return SignatureProperty.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.class, getSignaturePropertyTypeChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertyBuilder extends SignatureProperty, SignaturePropertyType.SignaturePropertyTypeBuilder {
		@Override
		SignatureProperty.SignaturePropertyBuilder setTarget(String target);
		@Override
		SignatureProperty.SignaturePropertyBuilder setId(String id);
		@Override
		SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice);
		@Override
		SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice, int idx);
		@Override
		SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice);
		@Override
		SignatureProperty.SignaturePropertyBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder.class, getSignaturePropertyTypeChoice());
		}
		

		SignatureProperty.SignaturePropertyBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureProperty  ***********************/
	class SignaturePropertyImpl extends SignaturePropertyType.SignaturePropertyTypeImpl implements SignatureProperty {
		
		protected SignaturePropertyImpl(SignatureProperty.SignaturePropertyBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureProperty build() {
			return this;
		}
		
		@Override
		public SignatureProperty.SignaturePropertyBuilder toBuilder() {
			SignatureProperty.SignaturePropertyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureProperty.SignaturePropertyBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureProperty {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureProperty  ***********************/
	class SignaturePropertyBuilderImpl extends SignaturePropertyType.SignaturePropertyTypeBuilderImpl implements SignatureProperty.SignaturePropertyBuilder {
	
		
		@RosettaAttribute("target")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("target")
		@Override
		public SignatureProperty.SignaturePropertyBuilder setTarget(String _target) {
			this.target = _target == null ? null : _target;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignatureProperty.SignaturePropertyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("signaturePropertyTypeChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("signaturePropertyTypeChoice")
		@Override
		public SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice _signaturePropertyTypeChoice) {
			if (_signaturePropertyTypeChoice != null) {
				this.signaturePropertyTypeChoice.add(_signaturePropertyTypeChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice _signaturePropertyTypeChoice, int idx) {
			getIndex(this.signaturePropertyTypeChoice, idx, () -> _signaturePropertyTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public SignatureProperty.SignaturePropertyBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
			if (signaturePropertyTypeChoices != null) {
				for (final SignaturePropertyTypeChoice toAdd : signaturePropertyTypeChoices) {
					this.signaturePropertyTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("signaturePropertyTypeChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("signaturePropertyTypeChoice")
		@Override
		public SignatureProperty.SignaturePropertyBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
			if (signaturePropertyTypeChoices == null) {
				this.signaturePropertyTypeChoice = new ArrayList<>();
			} else {
				this.signaturePropertyTypeChoice = signaturePropertyTypeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SignatureProperty build() {
			return new SignatureProperty.SignaturePropertyImpl(this);
		}
		
		@Override
		public SignatureProperty.SignaturePropertyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureProperty.SignaturePropertyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureProperty.SignaturePropertyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SignatureProperty.SignaturePropertyBuilder o = (SignatureProperty.SignaturePropertyBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
