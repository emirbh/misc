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
import fpml.consolidated.meta.SignatureMeta;
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
@RosettaDataType(value="Signature", builder=Signature.SignatureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Signature", model="fpml", builder=Signature.SignatureBuilderImpl.class, version="2.1.1")
public interface Signature extends SignatureType {

	SignatureMeta metaData = new SignatureMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Signature build();
	
	Signature.SignatureBuilder toBuilder();
	
	static Signature.SignatureBuilder builder() {
		return new Signature.SignatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Signature> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Signature> getType() {
		return Signature.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("signedInfo"), processor, SignedInfoType.class, getSignedInfo());
		processRosetta(path.newSubPath("signatureValue"), processor, SignatureValueType.class, getSignatureValue());
		processRosetta(path.newSubPath("keyInfo"), processor, KeyInfoType.class, getKeyInfo());
		processRosetta(path.newSubPath("object"), processor, ObjectType.class, getObject());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureBuilder extends Signature, SignatureType.SignatureTypeBuilder {
		@Override
		Signature.SignatureBuilder setId(String id);
		@Override
		Signature.SignatureBuilder setSignedInfo(SignedInfoType signedInfo);
		@Override
		Signature.SignatureBuilder setSignatureValue(SignatureValueType signatureValue);
		@Override
		Signature.SignatureBuilder setKeyInfo(KeyInfoType keyInfo);
		@Override
		Signature.SignatureBuilder addObject(ObjectType object);
		@Override
		Signature.SignatureBuilder addObject(ObjectType object, int idx);
		@Override
		Signature.SignatureBuilder addObject(List<? extends ObjectType> object);
		@Override
		Signature.SignatureBuilder setObject(List<? extends ObjectType> object);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("signedInfo"), processor, SignedInfoType.SignedInfoTypeBuilder.class, getSignedInfo());
			processRosetta(path.newSubPath("signatureValue"), processor, SignatureValueType.SignatureValueTypeBuilder.class, getSignatureValue());
			processRosetta(path.newSubPath("keyInfo"), processor, KeyInfoType.KeyInfoTypeBuilder.class, getKeyInfo());
			processRosetta(path.newSubPath("object"), processor, ObjectType.ObjectTypeBuilder.class, getObject());
		}
		

		Signature.SignatureBuilder prune();
	}

	/*********************** Immutable Implementation of Signature  ***********************/
	class SignatureImpl extends SignatureType.SignatureTypeImpl implements Signature {
		
		protected SignatureImpl(Signature.SignatureBuilder builder) {
			super(builder);
		}
		
		@Override
		public Signature build() {
			return this;
		}
		
		@Override
		public Signature.SignatureBuilder toBuilder() {
			Signature.SignatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Signature.SignatureBuilder builder) {
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
			return "Signature {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Signature  ***********************/
	class SignatureBuilderImpl extends SignatureType.SignatureTypeBuilderImpl implements Signature.SignatureBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Signature.SignatureBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("signedInfo")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("signedInfo")
		@Override
		public Signature.SignatureBuilder setSignedInfo(SignedInfoType _signedInfo) {
			this.signedInfo = _signedInfo == null ? null : _signedInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("signatureValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("signatureValue")
		@Override
		public Signature.SignatureBuilder setSignatureValue(SignatureValueType _signatureValue) {
			this.signatureValue = _signatureValue == null ? null : _signatureValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("keyInfo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("keyInfo")
		@Override
		public Signature.SignatureBuilder setKeyInfo(KeyInfoType _keyInfo) {
			this.keyInfo = _keyInfo == null ? null : _keyInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("object")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("object")
		@Override
		public Signature.SignatureBuilder addObject(ObjectType _object) {
			if (_object != null) {
				this.object.add(_object.toBuilder());
			}
			return this;
		}
		
		@Override
		public Signature.SignatureBuilder addObject(ObjectType _object, int idx) {
			getIndex(this.object, idx, () -> _object.toBuilder());
			return this;
		}
		
		@Override
		public Signature.SignatureBuilder addObject(List<? extends ObjectType> objects) {
			if (objects != null) {
				for (final ObjectType toAdd : objects) {
					this.object.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("object")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("object")
		@Override
		public Signature.SignatureBuilder setObject(List<? extends ObjectType> objects) {
			if (objects == null) {
				this.object = new ArrayList<>();
			} else {
				this.object = objects.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Signature build() {
			return new Signature.SignatureImpl(this);
		}
		
		@Override
		public Signature.SignatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Signature.SignatureBuilder prune() {
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
		public Signature.SignatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Signature.SignatureBuilder o = (Signature.SignatureBuilder) other;
			
			
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
			return "SignatureBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
