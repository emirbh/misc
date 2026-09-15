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
import fpml.consolidated.meta.SignatureTypeMeta;
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
@RosettaDataType(value="SignatureType", builder=SignatureType.SignatureTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignatureType", model="fpml", builder=SignatureType.SignatureTypeBuilderImpl.class, version="2.1.1")
public interface SignatureType extends RosettaModelObject {

	SignatureTypeMeta metaData = new SignatureTypeMeta();

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
	SignedInfoType getSignedInfo();
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
	SignatureValueType getSignatureValue();
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
	KeyInfoType getKeyInfo();
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
	List<? extends ObjectType> getObject();

	/*********************** Build Methods  ***********************/
	SignatureType build();
	
	SignatureType.SignatureTypeBuilder toBuilder();
	
	static SignatureType.SignatureTypeBuilder builder() {
		return new SignatureType.SignatureTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignatureType> getType() {
		return SignatureType.class;
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
	interface SignatureTypeBuilder extends SignatureType, RosettaModelObjectBuilder {
		SignedInfoType.SignedInfoTypeBuilder getOrCreateSignedInfo();
		@Override
		SignedInfoType.SignedInfoTypeBuilder getSignedInfo();
		SignatureValueType.SignatureValueTypeBuilder getOrCreateSignatureValue();
		@Override
		SignatureValueType.SignatureValueTypeBuilder getSignatureValue();
		KeyInfoType.KeyInfoTypeBuilder getOrCreateKeyInfo();
		@Override
		KeyInfoType.KeyInfoTypeBuilder getKeyInfo();
		ObjectType.ObjectTypeBuilder getOrCreateObject(int index);
		@Override
		List<? extends ObjectType.ObjectTypeBuilder> getObject();
		SignatureType.SignatureTypeBuilder setId(String id);
		SignatureType.SignatureTypeBuilder setSignedInfo(SignedInfoType signedInfo);
		SignatureType.SignatureTypeBuilder setSignatureValue(SignatureValueType signatureValue);
		SignatureType.SignatureTypeBuilder setKeyInfo(KeyInfoType keyInfo);
		SignatureType.SignatureTypeBuilder addObject(ObjectType object);
		SignatureType.SignatureTypeBuilder addObject(ObjectType object, int idx);
		SignatureType.SignatureTypeBuilder addObject(List<? extends ObjectType> object);
		SignatureType.SignatureTypeBuilder setObject(List<? extends ObjectType> object);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("signedInfo"), processor, SignedInfoType.SignedInfoTypeBuilder.class, getSignedInfo());
			processRosetta(path.newSubPath("signatureValue"), processor, SignatureValueType.SignatureValueTypeBuilder.class, getSignatureValue());
			processRosetta(path.newSubPath("keyInfo"), processor, KeyInfoType.KeyInfoTypeBuilder.class, getKeyInfo());
			processRosetta(path.newSubPath("object"), processor, ObjectType.ObjectTypeBuilder.class, getObject());
		}
		

		SignatureType.SignatureTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureType  ***********************/
	class SignatureTypeImpl implements SignatureType {
		private final String id;
		private final SignedInfoType signedInfo;
		private final SignatureValueType signatureValue;
		private final KeyInfoType keyInfo;
		private final List<? extends ObjectType> object;
		
		protected SignatureTypeImpl(SignatureType.SignatureTypeBuilder builder) {
			this.id = builder.getId();
			this.signedInfo = ofNullable(builder.getSignedInfo()).map(f->f.build()).orElse(null);
			this.signatureValue = ofNullable(builder.getSignatureValue()).map(f->f.build()).orElse(null);
			this.keyInfo = ofNullable(builder.getKeyInfo()).map(f->f.build()).orElse(null);
			this.object = ofNullable(builder.getObject()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("signedInfo")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("signedInfo")
		public SignedInfoType getSignedInfo() {
			return signedInfo;
		}
		
		@Override
		@RosettaAttribute("signatureValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("signatureValue")
		public SignatureValueType getSignatureValue() {
			return signatureValue;
		}
		
		@Override
		@RosettaAttribute("keyInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("keyInfo")
		public KeyInfoType getKeyInfo() {
			return keyInfo;
		}
		
		@Override
		@RosettaAttribute("object")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("object")
		public List<? extends ObjectType> getObject() {
			return object;
		}
		
		@Override
		public SignatureType build() {
			return this;
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder toBuilder() {
			SignatureType.SignatureTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureType.SignatureTypeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSignedInfo()).ifPresent(builder::setSignedInfo);
			ofNullable(getSignatureValue()).ifPresent(builder::setSignatureValue);
			ofNullable(getKeyInfo()).ifPresent(builder::setKeyInfo);
			ofNullable(getObject()).ifPresent(builder::setObject);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(signedInfo, _that.getSignedInfo())) return false;
			if (!Objects.equals(signatureValue, _that.getSignatureValue())) return false;
			if (!Objects.equals(keyInfo, _that.getKeyInfo())) return false;
			if (!ListEquals.listEquals(object, _that.getObject())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (signedInfo != null ? signedInfo.hashCode() : 0);
			_result = 31 * _result + (signatureValue != null ? signatureValue.hashCode() : 0);
			_result = 31 * _result + (keyInfo != null ? keyInfo.hashCode() : 0);
			_result = 31 * _result + (object != null ? object.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureType {" +
				"id=" + this.id + ", " +
				"signedInfo=" + this.signedInfo + ", " +
				"signatureValue=" + this.signatureValue + ", " +
				"keyInfo=" + this.keyInfo + ", " +
				"object=" + this.object +
			'}';
		}
	}

	/*********************** Builder Implementation of SignatureType  ***********************/
	class SignatureTypeBuilderImpl implements SignatureType.SignatureTypeBuilder {
	
		protected String id;
		protected SignedInfoType.SignedInfoTypeBuilder signedInfo;
		protected SignatureValueType.SignatureValueTypeBuilder signatureValue;
		protected KeyInfoType.KeyInfoTypeBuilder keyInfo;
		protected List<ObjectType.ObjectTypeBuilder> object = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("signedInfo")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("signedInfo")
		public SignedInfoType.SignedInfoTypeBuilder getSignedInfo() {
			return signedInfo;
		}
		
		@Override
		public SignedInfoType.SignedInfoTypeBuilder getOrCreateSignedInfo() {
			SignedInfoType.SignedInfoTypeBuilder result;
			if (signedInfo!=null) {
				result = signedInfo;
			}
			else {
				result = signedInfo = SignedInfoType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("signatureValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("signatureValue")
		public SignatureValueType.SignatureValueTypeBuilder getSignatureValue() {
			return signatureValue;
		}
		
		@Override
		public SignatureValueType.SignatureValueTypeBuilder getOrCreateSignatureValue() {
			SignatureValueType.SignatureValueTypeBuilder result;
			if (signatureValue!=null) {
				result = signatureValue;
			}
			else {
				result = signatureValue = SignatureValueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("keyInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("keyInfo")
		public KeyInfoType.KeyInfoTypeBuilder getKeyInfo() {
			return keyInfo;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder getOrCreateKeyInfo() {
			KeyInfoType.KeyInfoTypeBuilder result;
			if (keyInfo!=null) {
				result = keyInfo;
			}
			else {
				result = keyInfo = KeyInfoType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("object")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("object")
		public List<? extends ObjectType.ObjectTypeBuilder> getObject() {
			return object;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder getOrCreateObject(int index) {
			if (object==null) {
				this.object = new ArrayList<>();
			}
			return getIndex(object, index, () -> {
						ObjectType.ObjectTypeBuilder newObject = ObjectType.builder();
						return newObject;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignatureType.SignatureTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("signedInfo")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("signedInfo")
		@Override
		public SignatureType.SignatureTypeBuilder setSignedInfo(SignedInfoType _signedInfo) {
			this.signedInfo = _signedInfo == null ? null : _signedInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("signatureValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("signatureValue")
		@Override
		public SignatureType.SignatureTypeBuilder setSignatureValue(SignatureValueType _signatureValue) {
			this.signatureValue = _signatureValue == null ? null : _signatureValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("keyInfo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("keyInfo")
		@Override
		public SignatureType.SignatureTypeBuilder setKeyInfo(KeyInfoType _keyInfo) {
			this.keyInfo = _keyInfo == null ? null : _keyInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("object")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("object")
		@Override
		public SignatureType.SignatureTypeBuilder addObject(ObjectType _object) {
			if (_object != null) {
				this.object.add(_object.toBuilder());
			}
			return this;
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder addObject(ObjectType _object, int idx) {
			getIndex(this.object, idx, () -> _object.toBuilder());
			return this;
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder addObject(List<? extends ObjectType> objects) {
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
		public SignatureType.SignatureTypeBuilder setObject(List<? extends ObjectType> objects) {
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
		public SignatureType build() {
			return new SignatureType.SignatureTypeImpl(this);
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureType.SignatureTypeBuilder prune() {
			if (signedInfo!=null && !signedInfo.prune().hasData()) signedInfo = null;
			if (signatureValue!=null && !signatureValue.prune().hasData()) signatureValue = null;
			if (keyInfo!=null && !keyInfo.prune().hasData()) keyInfo = null;
			object = object.stream().filter(b->b!=null).<ObjectType.ObjectTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getSignedInfo()!=null && getSignedInfo().hasData()) return true;
			if (getSignatureValue()!=null && getSignatureValue().hasData()) return true;
			if (getKeyInfo()!=null && getKeyInfo().hasData()) return true;
			if (getObject()!=null && getObject().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureType.SignatureTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignatureType.SignatureTypeBuilder o = (SignatureType.SignatureTypeBuilder) other;
			
			merger.mergeRosetta(getSignedInfo(), o.getSignedInfo(), this::setSignedInfo);
			merger.mergeRosetta(getSignatureValue(), o.getSignatureValue(), this::setSignatureValue);
			merger.mergeRosetta(getKeyInfo(), o.getKeyInfo(), this::setKeyInfo);
			merger.mergeRosetta(getObject(), o.getObject(), this::getOrCreateObject);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignatureType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(signedInfo, _that.getSignedInfo())) return false;
			if (!Objects.equals(signatureValue, _that.getSignatureValue())) return false;
			if (!Objects.equals(keyInfo, _that.getKeyInfo())) return false;
			if (!ListEquals.listEquals(object, _that.getObject())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (signedInfo != null ? signedInfo.hashCode() : 0);
			_result = 31 * _result + (signatureValue != null ? signatureValue.hashCode() : 0);
			_result = 31 * _result + (keyInfo != null ? keyInfo.hashCode() : 0);
			_result = 31 * _result + (object != null ? object.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureTypeBuilder {" +
				"id=" + this.id + ", " +
				"signedInfo=" + this.signedInfo + ", " +
				"signatureValue=" + this.signatureValue + ", " +
				"keyInfo=" + this.keyInfo + ", " +
				"object=" + this.object +
			'}';
		}
	}
}
