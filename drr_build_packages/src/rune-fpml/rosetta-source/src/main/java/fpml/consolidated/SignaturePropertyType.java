package fpml.consolidated;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.meta.SignaturePropertyTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

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
@RosettaDataType(value="SignaturePropertyType", builder=SignaturePropertyType.SignaturePropertyTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignaturePropertyType", model="fpml", builder=SignaturePropertyType.SignaturePropertyTypeBuilderImpl.class, version="2.1.1")
public interface SignaturePropertyType extends RosettaModelObject {

	SignaturePropertyTypeMeta metaData = new SignaturePropertyTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getTarget();
	/**
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
	String getId();
	/**
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
	List<? extends SignaturePropertyTypeChoice> getSignaturePropertyTypeChoice();

	/*********************** Build Methods  ***********************/
	SignaturePropertyType build();
	
	SignaturePropertyType.SignaturePropertyTypeBuilder toBuilder();
	
	static SignaturePropertyType.SignaturePropertyTypeBuilder builder() {
		return new SignaturePropertyType.SignaturePropertyTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignaturePropertyType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignaturePropertyType> getType() {
		return SignaturePropertyType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.class, getSignaturePropertyTypeChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertyTypeBuilder extends SignaturePropertyType, RosettaModelObjectBuilder {
		SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder getOrCreateSignaturePropertyTypeChoice(int index);
		@Override
		List<? extends SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder> getSignaturePropertyTypeChoice();
		SignaturePropertyType.SignaturePropertyTypeBuilder setTarget(String target);
		SignaturePropertyType.SignaturePropertyTypeBuilder setId(String id);
		SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice);
		SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice, int idx);
		SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice);
		SignaturePropertyType.SignaturePropertyTypeBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder.class, getSignaturePropertyTypeChoice());
		}
		

		SignaturePropertyType.SignaturePropertyTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignaturePropertyType  ***********************/
	class SignaturePropertyTypeImpl implements SignaturePropertyType {
		private final String target;
		private final String id;
		private final List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice;
		
		protected SignaturePropertyTypeImpl(SignaturePropertyType.SignaturePropertyTypeBuilder builder) {
			this.target = builder.getTarget();
			this.id = builder.getId();
			this.signaturePropertyTypeChoice = ofNullable(builder.getSignaturePropertyTypeChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("target")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("target")
		public String getTarget() {
			return target;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("signaturePropertyTypeChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("signaturePropertyTypeChoice")
		public List<? extends SignaturePropertyTypeChoice> getSignaturePropertyTypeChoice() {
			return signaturePropertyTypeChoice;
		}
		
		@Override
		public SignaturePropertyType build() {
			return this;
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder toBuilder() {
			SignaturePropertyType.SignaturePropertyTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignaturePropertyType.SignaturePropertyTypeBuilder builder) {
			ofNullable(getTarget()).ifPresent(builder::setTarget);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSignaturePropertyTypeChoice()).ifPresent(builder::setSignaturePropertyTypeChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertyType _that = getType().cast(o);
		
			if (!Objects.equals(target, _that.getTarget())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(signaturePropertyTypeChoice, _that.getSignaturePropertyTypeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (signaturePropertyTypeChoice != null ? signaturePropertyTypeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyType {" +
				"target=" + this.target + ", " +
				"id=" + this.id + ", " +
				"signaturePropertyTypeChoice=" + this.signaturePropertyTypeChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of SignaturePropertyType  ***********************/
	class SignaturePropertyTypeBuilderImpl implements SignaturePropertyType.SignaturePropertyTypeBuilder {
	
		protected String target;
		protected String id;
		protected List<SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder> signaturePropertyTypeChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("target")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("target")
		public String getTarget() {
			return target;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("signaturePropertyTypeChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("signaturePropertyTypeChoice")
		public List<? extends SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder> getSignaturePropertyTypeChoice() {
			return signaturePropertyTypeChoice;
		}
		
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder getOrCreateSignaturePropertyTypeChoice(int index) {
			if (signaturePropertyTypeChoice==null) {
				this.signaturePropertyTypeChoice = new ArrayList<>();
			}
			return getIndex(signaturePropertyTypeChoice, index, () -> {
						SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder newSignaturePropertyTypeChoice = SignaturePropertyTypeChoice.builder();
						return newSignaturePropertyTypeChoice;
					});
		}
		
		@RosettaAttribute("target")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("target")
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder setTarget(String _target) {
			this.target = _target == null ? null : _target;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("signaturePropertyTypeChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("signaturePropertyTypeChoice")
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice _signaturePropertyTypeChoice) {
			if (_signaturePropertyTypeChoice != null) {
				this.signaturePropertyTypeChoice.add(_signaturePropertyTypeChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice _signaturePropertyTypeChoice, int idx) {
			getIndex(this.signaturePropertyTypeChoice, idx, () -> _signaturePropertyTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
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
		public SignaturePropertyType.SignaturePropertyTypeBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
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
		public SignaturePropertyType build() {
			return new SignaturePropertyType.SignaturePropertyTypeImpl(this);
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder prune() {
			signaturePropertyTypeChoice = signaturePropertyTypeChoice.stream().filter(b->b!=null).<SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTarget()!=null) return true;
			if (getId()!=null) return true;
			if (getSignaturePropertyTypeChoice()!=null && getSignaturePropertyTypeChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignaturePropertyType.SignaturePropertyTypeBuilder o = (SignaturePropertyType.SignaturePropertyTypeBuilder) other;
			
			merger.mergeRosetta(getSignaturePropertyTypeChoice(), o.getSignaturePropertyTypeChoice(), this::getOrCreateSignaturePropertyTypeChoice);
			
			merger.mergeBasic(getTarget(), o.getTarget(), this::setTarget);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertyType _that = getType().cast(o);
		
			if (!Objects.equals(target, _that.getTarget())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(signaturePropertyTypeChoice, _that.getSignaturePropertyTypeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (signaturePropertyTypeChoice != null ? signaturePropertyTypeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyTypeBuilder {" +
				"target=" + this.target + ", " +
				"id=" + this.id + ", " +
				"signaturePropertyTypeChoice=" + this.signaturePropertyTypeChoice +
			'}';
		}
	}
}
