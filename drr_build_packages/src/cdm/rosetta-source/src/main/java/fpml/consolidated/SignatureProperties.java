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
import fpml.consolidated.meta.SignaturePropertiesMeta;
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
@RosettaDataType(value="SignatureProperties", builder=SignatureProperties.SignaturePropertiesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignatureProperties", model="fpml", builder=SignatureProperties.SignaturePropertiesBuilderImpl.class, version="2.1.1")
public interface SignatureProperties extends SignaturePropertiesType {

	SignaturePropertiesMeta metaData = new SignaturePropertiesMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureProperties build();
	
	SignatureProperties.SignaturePropertiesBuilder toBuilder();
	
	static SignatureProperties.SignaturePropertiesBuilder builder() {
		return new SignatureProperties.SignaturePropertiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureProperties> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignatureProperties> getType() {
		return SignatureProperties.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.class, getSignatureProperty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertiesBuilder extends SignatureProperties, SignaturePropertiesType.SignaturePropertiesTypeBuilder {
		@Override
		SignatureProperties.SignaturePropertiesBuilder setId(String id);
		@Override
		SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType signatureProperty);
		@Override
		SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType signatureProperty, int idx);
		@Override
		SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(List<? extends SignaturePropertyType> signatureProperty);
		@Override
		SignatureProperties.SignaturePropertiesBuilder setSignatureProperty(List<? extends SignaturePropertyType> signatureProperty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("signatureProperty"), processor, SignaturePropertyType.SignaturePropertyTypeBuilder.class, getSignatureProperty());
		}
		

		SignatureProperties.SignaturePropertiesBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureProperties  ***********************/
	class SignaturePropertiesImpl extends SignaturePropertiesType.SignaturePropertiesTypeImpl implements SignatureProperties {
		
		protected SignaturePropertiesImpl(SignatureProperties.SignaturePropertiesBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureProperties build() {
			return this;
		}
		
		@Override
		public SignatureProperties.SignaturePropertiesBuilder toBuilder() {
			SignatureProperties.SignaturePropertiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureProperties.SignaturePropertiesBuilder builder) {
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
			return "SignatureProperties {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureProperties  ***********************/
	class SignaturePropertiesBuilderImpl extends SignaturePropertiesType.SignaturePropertiesTypeBuilderImpl implements SignatureProperties.SignaturePropertiesBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignatureProperties.SignaturePropertiesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("signatureProperty")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("signatureProperty")
		@Override
		public SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType _signatureProperty) {
			if (_signatureProperty != null) {
				this.signatureProperty.add(_signatureProperty.toBuilder());
			}
			return this;
		}
		
		@Override
		public SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(SignaturePropertyType _signatureProperty, int idx) {
			getIndex(this.signatureProperty, idx, () -> _signatureProperty.toBuilder());
			return this;
		}
		
		@Override
		public SignatureProperties.SignaturePropertiesBuilder addSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
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
		public SignatureProperties.SignaturePropertiesBuilder setSignatureProperty(List<? extends SignaturePropertyType> signaturePropertys) {
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
		public SignatureProperties build() {
			return new SignatureProperties.SignaturePropertiesImpl(this);
		}
		
		@Override
		public SignatureProperties.SignaturePropertiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureProperties.SignaturePropertiesBuilder prune() {
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
		public SignatureProperties.SignaturePropertiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SignatureProperties.SignaturePropertiesBuilder o = (SignatureProperties.SignaturePropertiesBuilder) other;
			
			
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
			return "SignaturePropertiesBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
