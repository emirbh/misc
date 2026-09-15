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
import fpml.consolidated.meta.SignaturePropertiesTypeMeta;
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
@RosettaDataType(value="SignaturePropertiesType", builder=SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignaturePropertiesType", model="fpml", builder=SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl.class, version="2.1.1")
public interface SignaturePropertiesType extends RosettaModelObject {

	SignaturePropertiesTypeMeta metaData = new SignaturePropertiesTypeMeta();

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
	List<? extends SignaturePropertyType> getSignatureProperty();

	/*********************** Build Methods  ***********************/
	SignaturePropertiesType build();
	
	SignaturePropertiesType.SignaturePropertiesTypeBuilder toBuilder();
	
	static SignaturePropertiesType.SignaturePropertiesTypeBuilder builder() {
		return new SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignaturePropertiesType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignaturePropertiesType> getType() {
		return SignaturePropertiesType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.class, getSignatureProperty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertiesTypeBuilder extends SignaturePropertiesType, RosettaModelObjectBuilder {
		SignaturePropertyType.SignaturePropertyTypeBuilder getOrCreateSignatureProperty(int index);
		@Override
		List<? extends SignaturePropertyType.SignaturePropertyTypeBuilder> getSignatureProperty();
		SignaturePropertiesType.SignaturePropertiesTypeBuilder setId(String id);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType signatureProperty);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType signatureProperty, int idx);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(List<? extends SignaturePropertyType> signatureProperty);
		SignaturePropertiesType.SignaturePropertiesTypeBuilder setSignatureProperty(List<? extends SignaturePropertyType> signatureProperty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.SignaturePropertyTypeBuilder.class, getSignatureProperty());
		}
		

		SignaturePropertiesType.SignaturePropertiesTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignaturePropertiesType  ***********************/
	class SignaturePropertiesTypeImpl implements SignaturePropertiesType {
		private final String id;
		private final List<? extends SignaturePropertyType> signatureProperty;
		
		protected SignaturePropertiesTypeImpl(SignaturePropertiesType.SignaturePropertiesTypeBuilder builder) {
			this.id = builder.getId();
			this.signatureProperty = ofNullable(builder.getSignatureProperty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("signatureProperty")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("signatureProperty")
		public List<? extends SignaturePropertyType> getSignatureProperty() {
			return signatureProperty;
		}
		
		@Override
		public SignaturePropertiesType build() {
			return this;
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder toBuilder() {
			SignaturePropertiesType.SignaturePropertiesTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignaturePropertiesType.SignaturePropertiesTypeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSignatureProperty()).ifPresent(builder::setSignatureProperty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertiesType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(signatureProperty, _that.getSignatureProperty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (signatureProperty != null ? signatureProperty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertiesType {" +
				"id=" + this.id + ", " +
				"signatureProperty=" + this.signatureProperty +
			'}';
		}
	}

	/*********************** Builder Implementation of SignaturePropertiesType  ***********************/
	class SignaturePropertiesTypeBuilderImpl implements SignaturePropertiesType.SignaturePropertiesTypeBuilder {
	
		protected String id;
		protected List<SignaturePropertyType.SignaturePropertyTypeBuilder> signatureProperty = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("signatureProperty")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("signatureProperty")
		public List<? extends SignaturePropertyType.SignaturePropertyTypeBuilder> getSignatureProperty() {
			return signatureProperty;
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder getOrCreateSignatureProperty(int index) {
			if (signatureProperty==null) {
				this.signatureProperty = new ArrayList<>();
			}
			return getIndex(signatureProperty, index, () -> {
						SignaturePropertyType.SignaturePropertyTypeBuilder newSignatureProperty = SignaturePropertyType.builder();
						return newSignatureProperty;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("signatureProperty")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("signatureProperty")
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType _signatureProperty) {
			if (_signatureProperty != null) {
				this.signatureProperty.add(_signatureProperty.toBuilder());
			}
			return this;
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(SignaturePropertyType _signatureProperty, int idx) {
			getIndex(this.signatureProperty, idx, () -> _signatureProperty.toBuilder());
			return this;
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder addSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
			if (signaturePropertys != null) {
				for (final SignaturePropertyType toAdd : signaturePropertys) {
					this.signatureProperty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("signatureProperty")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("signatureProperty")
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder setSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
			if (signaturePropertys == null) {
				this.signatureProperty = new ArrayList<>();
			} else {
				this.signatureProperty = signaturePropertys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SignaturePropertiesType build() {
			return new SignaturePropertiesType.SignaturePropertiesTypeImpl(this);
		}
		
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder prune() {
			signatureProperty = signatureProperty.stream().filter(b->b!=null).<SignaturePropertyType.SignaturePropertyTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getSignatureProperty()!=null && getSignatureProperty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertiesType.SignaturePropertiesTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignaturePropertiesType.SignaturePropertiesTypeBuilder o = (SignaturePropertiesType.SignaturePropertiesTypeBuilder) other;
			
			merger.mergeRosetta(getSignatureProperty(), o.getSignatureProperty(), this::getOrCreateSignatureProperty);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertiesType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(signatureProperty, _that.getSignatureProperty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (signatureProperty != null ? signatureProperty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertiesTypeBuilder {" +
				"id=" + this.id + ", " +
				"signatureProperty=" + this.signatureProperty +
			'}';
		}
	}
}
