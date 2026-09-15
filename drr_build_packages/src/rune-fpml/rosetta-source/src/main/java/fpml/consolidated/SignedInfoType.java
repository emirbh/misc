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
import fpml.consolidated.meta.SignedInfoTypeMeta;
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
@RosettaDataType(value="SignedInfoType", builder=SignedInfoType.SignedInfoTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignedInfoType", model="fpml", builder=SignedInfoType.SignedInfoTypeBuilderImpl.class, version="2.1.1")
public interface SignedInfoType extends RosettaModelObject {

	SignedInfoTypeMeta metaData = new SignedInfoTypeMeta();

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
	CanonicalizationMethodType getCanonicalizationMethod();
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
	SignatureMethodType getSignatureMethod();
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
	List<? extends ReferenceType> getReference();

	/*********************** Build Methods  ***********************/
	SignedInfoType build();
	
	SignedInfoType.SignedInfoTypeBuilder toBuilder();
	
	static SignedInfoType.SignedInfoTypeBuilder builder() {
		return new SignedInfoType.SignedInfoTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignedInfoType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignedInfoType> getType() {
		return SignedInfoType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.class, getCanonicalizationMethod());
		processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.class, getSignatureMethod());
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignedInfoTypeBuilder extends SignedInfoType, RosettaModelObjectBuilder {
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getOrCreateCanonicalizationMethod();
		@Override
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getCanonicalizationMethod();
		SignatureMethodType.SignatureMethodTypeBuilder getOrCreateSignatureMethod();
		@Override
		SignatureMethodType.SignatureMethodTypeBuilder getSignatureMethod();
		ReferenceType.ReferenceTypeBuilder getOrCreateReference(int index);
		@Override
		List<? extends ReferenceType.ReferenceTypeBuilder> getReference();
		SignedInfoType.SignedInfoTypeBuilder setId(String id);
		SignedInfoType.SignedInfoTypeBuilder setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethod);
		SignedInfoType.SignedInfoTypeBuilder setSignatureMethod(SignatureMethodType signatureMethod);
		SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType reference);
		SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType reference, int idx);
		SignedInfoType.SignedInfoTypeBuilder addReference(List<? extends ReferenceType> reference);
		SignedInfoType.SignedInfoTypeBuilder setReference(List<? extends ReferenceType> reference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("canonicalizationMethod"), processor, CanonicalizationMethodType.CanonicalizationMethodTypeBuilder.class, getCanonicalizationMethod());
			processRosetta(path.newSubPath("signatureMethod"), processor, SignatureMethodType.SignatureMethodTypeBuilder.class, getSignatureMethod());
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
		}
		

		SignedInfoType.SignedInfoTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignedInfoType  ***********************/
	class SignedInfoTypeImpl implements SignedInfoType {
		private final String id;
		private final CanonicalizationMethodType canonicalizationMethod;
		private final SignatureMethodType signatureMethod;
		private final List<? extends ReferenceType> reference;
		
		protected SignedInfoTypeImpl(SignedInfoType.SignedInfoTypeBuilder builder) {
			this.id = builder.getId();
			this.canonicalizationMethod = ofNullable(builder.getCanonicalizationMethod()).map(f->f.build()).orElse(null);
			this.signatureMethod = ofNullable(builder.getSignatureMethod()).map(f->f.build()).orElse(null);
			this.reference = ofNullable(builder.getReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("canonicalizationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("canonicalizationMethod")
		public CanonicalizationMethodType getCanonicalizationMethod() {
			return canonicalizationMethod;
		}
		
		@Override
		@RosettaAttribute("signatureMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("signatureMethod")
		public SignatureMethodType getSignatureMethod() {
			return signatureMethod;
		}
		
		@Override
		@RosettaAttribute("reference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("reference")
		public List<? extends ReferenceType> getReference() {
			return reference;
		}
		
		@Override
		public SignedInfoType build() {
			return this;
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder toBuilder() {
			SignedInfoType.SignedInfoTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignedInfoType.SignedInfoTypeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCanonicalizationMethod()).ifPresent(builder::setCanonicalizationMethod);
			ofNullable(getSignatureMethod()).ifPresent(builder::setSignatureMethod);
			ofNullable(getReference()).ifPresent(builder::setReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignedInfoType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(canonicalizationMethod, _that.getCanonicalizationMethod())) return false;
			if (!Objects.equals(signatureMethod, _that.getSignatureMethod())) return false;
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (canonicalizationMethod != null ? canonicalizationMethod.hashCode() : 0);
			_result = 31 * _result + (signatureMethod != null ? signatureMethod.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignedInfoType {" +
				"id=" + this.id + ", " +
				"canonicalizationMethod=" + this.canonicalizationMethod + ", " +
				"signatureMethod=" + this.signatureMethod + ", " +
				"reference=" + this.reference +
			'}';
		}
	}

	/*********************** Builder Implementation of SignedInfoType  ***********************/
	class SignedInfoTypeBuilderImpl implements SignedInfoType.SignedInfoTypeBuilder {
	
		protected String id;
		protected CanonicalizationMethodType.CanonicalizationMethodTypeBuilder canonicalizationMethod;
		protected SignatureMethodType.SignatureMethodTypeBuilder signatureMethod;
		protected List<ReferenceType.ReferenceTypeBuilder> reference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("canonicalizationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("canonicalizationMethod")
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getCanonicalizationMethod() {
			return canonicalizationMethod;
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder getOrCreateCanonicalizationMethod() {
			CanonicalizationMethodType.CanonicalizationMethodTypeBuilder result;
			if (canonicalizationMethod!=null) {
				result = canonicalizationMethod;
			}
			else {
				result = canonicalizationMethod = CanonicalizationMethodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("signatureMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("signatureMethod")
		public SignatureMethodType.SignatureMethodTypeBuilder getSignatureMethod() {
			return signatureMethod;
		}
		
		@Override
		public SignatureMethodType.SignatureMethodTypeBuilder getOrCreateSignatureMethod() {
			SignatureMethodType.SignatureMethodTypeBuilder result;
			if (signatureMethod!=null) {
				result = signatureMethod;
			}
			else {
				result = signatureMethod = SignatureMethodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("reference")
		public List<? extends ReferenceType.ReferenceTypeBuilder> getReference() {
			return reference;
		}
		
		@Override
		public ReferenceType.ReferenceTypeBuilder getOrCreateReference(int index) {
			if (reference==null) {
				this.reference = new ArrayList<>();
			}
			return getIndex(reference, index, () -> {
						ReferenceType.ReferenceTypeBuilder newReference = ReferenceType.builder();
						return newReference;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("canonicalizationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("canonicalizationMethod")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder setCanonicalizationMethod(CanonicalizationMethodType _canonicalizationMethod) {
			this.canonicalizationMethod = _canonicalizationMethod == null ? null : _canonicalizationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("signatureMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("signatureMethod")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder setSignatureMethod(SignatureMethodType _signatureMethod) {
			this.signatureMethod = _signatureMethod == null ? null : _signatureMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("reference")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType _reference) {
			if (_reference != null) {
				this.reference.add(_reference.toBuilder());
			}
			return this;
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder addReference(ReferenceType _reference, int idx) {
			getIndex(this.reference, idx, () -> _reference.toBuilder());
			return this;
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder addReference(List<? extends ReferenceType> references) {
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
		public SignedInfoType.SignedInfoTypeBuilder setReference(List<? extends ReferenceType> references) {
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
		public SignedInfoType build() {
			return new SignedInfoType.SignedInfoTypeImpl(this);
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder prune() {
			if (canonicalizationMethod!=null && !canonicalizationMethod.prune().hasData()) canonicalizationMethod = null;
			if (signatureMethod!=null && !signatureMethod.prune().hasData()) signatureMethod = null;
			reference = reference.stream().filter(b->b!=null).<ReferenceType.ReferenceTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCanonicalizationMethod()!=null && getCanonicalizationMethod().hasData()) return true;
			if (getSignatureMethod()!=null && getSignatureMethod().hasData()) return true;
			if (getReference()!=null && getReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignedInfoType.SignedInfoTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignedInfoType.SignedInfoTypeBuilder o = (SignedInfoType.SignedInfoTypeBuilder) other;
			
			merger.mergeRosetta(getCanonicalizationMethod(), o.getCanonicalizationMethod(), this::setCanonicalizationMethod);
			merger.mergeRosetta(getSignatureMethod(), o.getSignatureMethod(), this::setSignatureMethod);
			merger.mergeRosetta(getReference(), o.getReference(), this::getOrCreateReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignedInfoType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(canonicalizationMethod, _that.getCanonicalizationMethod())) return false;
			if (!Objects.equals(signatureMethod, _that.getSignatureMethod())) return false;
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (canonicalizationMethod != null ? canonicalizationMethod.hashCode() : 0);
			_result = 31 * _result + (signatureMethod != null ? signatureMethod.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignedInfoTypeBuilder {" +
				"id=" + this.id + ", " +
				"canonicalizationMethod=" + this.canonicalizationMethod + ", " +
				"signatureMethod=" + this.signatureMethod + ", " +
				"reference=" + this.reference +
			'}';
		}
	}
}
