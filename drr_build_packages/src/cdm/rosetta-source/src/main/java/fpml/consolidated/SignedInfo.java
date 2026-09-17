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
import fpml.consolidated.meta.SignedInfoMeta;
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
@RosettaDataType(value="SignedInfo", builder=SignedInfo.SignedInfoBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignedInfo", model="fpml", builder=SignedInfo.SignedInfoBuilderImpl.class, version="2.1.1")
public interface SignedInfo extends SignedInfoType {

	SignedInfoMeta metaData = new SignedInfoMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignedInfo build();
	
	SignedInfo.SignedInfoBuilder toBuilder();
	
	static SignedInfo.SignedInfoBuilder builder() {
		return new SignedInfo.SignedInfoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignedInfo> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignedInfo> getType() {
		return SignedInfo.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.class, getCanonicalizationMethod());
		processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.class, getSignatureMethod());
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignedInfoBuilder extends SignedInfo, SignedInfoType.SignedInfoTypeBuilder {
		@Override
		SignedInfo.SignedInfoBuilder setId(String id);
		@Override
		SignedInfo.SignedInfoBuilder setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethod);
		@Override
		SignedInfo.SignedInfoBuilder setSignatureMethod(SignatureMethodType signatureMethod);
		@Override
		SignedInfo.SignedInfoBuilder addReference(ReferenceType reference);
		@Override
		SignedInfo.SignedInfoBuilder addReference(ReferenceType reference, int idx);
		@Override
		SignedInfo.SignedInfoBuilder addReference(List<? extends ReferenceType> reference);
		@Override
		SignedInfo.SignedInfoBuilder setReference(List<? extends ReferenceType> reference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.CanonicalizationMethodTypeBuilder.class, getCanonicalizationMethod());
			processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.SignatureMethodTypeBuilder.class, getSignatureMethod());
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
		}
		

		SignedInfo.SignedInfoBuilder prune();
	}

	/*********************** Immutable Implementation of SignedInfo  ***********************/
	class SignedInfoImpl extends SignedInfoType.SignedInfoTypeImpl implements SignedInfo {
		
		protected SignedInfoImpl(SignedInfo.SignedInfoBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignedInfo build() {
			return this;
		}
		
		@Override
		public SignedInfo.SignedInfoBuilder toBuilder() {
			SignedInfo.SignedInfoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignedInfo.SignedInfoBuilder builder) {
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
			return "SignedInfo {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignedInfo  ***********************/
	class SignedInfoBuilderImpl extends SignedInfoType.SignedInfoTypeBuilderImpl implements SignedInfo.SignedInfoBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignedInfo.SignedInfoBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("canonicalizationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("canonicalizationMethod")
		@Override
		public SignedInfo.SignedInfoBuilder setCanonicalizationMethod(CanonicalizationMethodType _canonicalizationMethod) {
			this.canonicalizationMethod = _canonicalizationMethod == null ? null : _canonicalizationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("signatureMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("signatureMethod")
		@Override
		public SignedInfo.SignedInfoBuilder setSignatureMethod(SignatureMethodType _signatureMethod) {
			this.signatureMethod = _signatureMethod == null ? null : _signatureMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("reference")
		@Override
		public SignedInfo.SignedInfoBuilder addReference(ReferenceType _reference) {
			if (_reference != null) {
				this.reference.add(_reference.toBuilder());
			}
			return this;
		}
		
		@Override
		public SignedInfo.SignedInfoBuilder addReference(ReferenceType _reference, int idx) {
			getIndex(this.reference, idx, () -> _reference.toBuilder());
			return this;
		}
		
		@Override
		public SignedInfo.SignedInfoBuilder addReference(List<? extends ReferenceType> references) {
			if (references != null) {
				for (final ReferenceType toAdd : references) {
					this.reference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reference")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("reference")
		@Override
		public SignedInfo.SignedInfoBuilder setReference(List<? extends ReferenceType> references) {
			if (references == null) {
				this.reference = new ArrayList<>();
			} else {
				this.reference = references.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SignedInfo build() {
			return new SignedInfo.SignedInfoImpl(this);
		}
		
		@Override
		public SignedInfo.SignedInfoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignedInfo.SignedInfoBuilder prune() {
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
		public SignedInfo.SignedInfoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SignedInfo.SignedInfoBuilder o = (SignedInfo.SignedInfoBuilder) other;
			
			
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
			return "SignedInfoBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
