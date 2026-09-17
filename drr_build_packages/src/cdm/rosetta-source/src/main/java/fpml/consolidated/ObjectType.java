package fpml.consolidated;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.meta.ObjectTypeMeta;
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
@RosettaDataType(value="ObjectType", builder=ObjectType.ObjectTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObjectType", model="fpml", builder=ObjectType.ObjectTypeBuilderImpl.class, version="2.1.1")
public interface ObjectType extends RosettaModelObject {

	ObjectTypeMeta metaData = new ObjectTypeMeta();

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
	String getMimeType();
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
	String getEncoding();
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
	List<? extends ObjectTypeSequence> getObjectTypeSequence();

	/*********************** Build Methods  ***********************/
	ObjectType build();
	
	ObjectType.ObjectTypeBuilder toBuilder();
	
	static ObjectType.ObjectTypeBuilder builder() {
		return new ObjectType.ObjectTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObjectType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObjectType> getType() {
		return ObjectType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
		processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
		processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.class, getObjectTypeSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObjectTypeBuilder extends ObjectType, RosettaModelObjectBuilder {
		ObjectTypeSequence.ObjectTypeSequenceBuilder getOrCreateObjectTypeSequence(int index);
		@Override
		List<? extends ObjectTypeSequence.ObjectTypeSequenceBuilder> getObjectTypeSequence();
		ObjectType.ObjectTypeBuilder setId(String id);
		ObjectType.ObjectTypeBuilder setMimeType(String mimeType);
		ObjectType.ObjectTypeBuilder setEncoding(String encoding);
		ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence);
		ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence, int idx);
		ObjectType.ObjectTypeBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence);
		ObjectType.ObjectTypeBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
			processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
			processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.ObjectTypeSequenceBuilder.class, getObjectTypeSequence());
		}
		

		ObjectType.ObjectTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ObjectType  ***********************/
	class ObjectTypeImpl implements ObjectType {
		private final String id;
		private final String mimeType;
		private final String encoding;
		private final List<? extends ObjectTypeSequence> objectTypeSequence;
		
		protected ObjectTypeImpl(ObjectType.ObjectTypeBuilder builder) {
			this.id = builder.getId();
			this.mimeType = builder.getMimeType();
			this.encoding = builder.getEncoding();
			this.objectTypeSequence = ofNullable(builder.getObjectTypeSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mimeType")
		public String getMimeType() {
			return mimeType;
		}
		
		@Override
		@RosettaAttribute("encoding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("encoding")
		public String getEncoding() {
			return encoding;
		}
		
		@Override
		@RosettaAttribute("objectTypeSequence")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("objectTypeSequence")
		public List<? extends ObjectTypeSequence> getObjectTypeSequence() {
			return objectTypeSequence;
		}
		
		@Override
		public ObjectType build() {
			return this;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder toBuilder() {
			ObjectType.ObjectTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObjectType.ObjectTypeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getMimeType()).ifPresent(builder::setMimeType);
			ofNullable(getEncoding()).ifPresent(builder::setEncoding);
			ofNullable(getObjectTypeSequence()).ifPresent(builder::setObjectTypeSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObjectType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(encoding, _that.getEncoding())) return false;
			if (!ListEquals.listEquals(objectTypeSequence, _that.getObjectTypeSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (encoding != null ? encoding.hashCode() : 0);
			_result = 31 * _result + (objectTypeSequence != null ? objectTypeSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectType {" +
				"id=" + this.id + ", " +
				"mimeType=" + this.mimeType + ", " +
				"encoding=" + this.encoding + ", " +
				"objectTypeSequence=" + this.objectTypeSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of ObjectType  ***********************/
	class ObjectTypeBuilderImpl implements ObjectType.ObjectTypeBuilder {
	
		protected String id;
		protected String mimeType;
		protected String encoding;
		protected List<ObjectTypeSequence.ObjectTypeSequenceBuilder> objectTypeSequence = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mimeType")
		public String getMimeType() {
			return mimeType;
		}
		
		@Override
		@RosettaAttribute("encoding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("encoding")
		public String getEncoding() {
			return encoding;
		}
		
		@Override
		@RosettaAttribute("objectTypeSequence")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("objectTypeSequence")
		public List<? extends ObjectTypeSequence.ObjectTypeSequenceBuilder> getObjectTypeSequence() {
			return objectTypeSequence;
		}
		
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder getOrCreateObjectTypeSequence(int index) {
			if (objectTypeSequence==null) {
				this.objectTypeSequence = new ArrayList<>();
			}
			return getIndex(objectTypeSequence, index, () -> {
						ObjectTypeSequence.ObjectTypeSequenceBuilder newObjectTypeSequence = ObjectTypeSequence.builder();
						return newObjectTypeSequence;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ObjectType.ObjectTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("mimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mimeType")
		@Override
		public ObjectType.ObjectTypeBuilder setMimeType(String _mimeType) {
			this.mimeType = _mimeType == null ? null : _mimeType;
			return this;
		}
		
		@RosettaAttribute("encoding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("encoding")
		@Override
		public ObjectType.ObjectTypeBuilder setEncoding(String _encoding) {
			this.encoding = _encoding == null ? null : _encoding;
			return this;
		}
		
		@RosettaAttribute("objectTypeSequence")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("objectTypeSequence")
		@Override
		public ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence _objectTypeSequence) {
			if (_objectTypeSequence != null) {
				this.objectTypeSequence.add(_objectTypeSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder addObjectTypeSequence(ObjectTypeSequence _objectTypeSequence, int idx) {
			getIndex(this.objectTypeSequence, idx, () -> _objectTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
			if (objectTypeSequences != null) {
				for (final ObjectTypeSequence toAdd : objectTypeSequences) {
					this.objectTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("objectTypeSequence")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("objectTypeSequence")
		@Override
		public ObjectType.ObjectTypeBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
			if (objectTypeSequences == null) {
				this.objectTypeSequence = new ArrayList<>();
			} else {
				this.objectTypeSequence = objectTypeSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ObjectType build() {
			return new ObjectType.ObjectTypeImpl(this);
		}
		
		@Override
		public ObjectType.ObjectTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectType.ObjectTypeBuilder prune() {
			objectTypeSequence = objectTypeSequence.stream().filter(b->b!=null).<ObjectTypeSequence.ObjectTypeSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getMimeType()!=null) return true;
			if (getEncoding()!=null) return true;
			if (getObjectTypeSequence()!=null && getObjectTypeSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectType.ObjectTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObjectType.ObjectTypeBuilder o = (ObjectType.ObjectTypeBuilder) other;
			
			merger.mergeRosetta(getObjectTypeSequence(), o.getObjectTypeSequence(), this::getOrCreateObjectTypeSequence);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getMimeType(), o.getMimeType(), this::setMimeType);
			merger.mergeBasic(getEncoding(), o.getEncoding(), this::setEncoding);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObjectType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(encoding, _that.getEncoding())) return false;
			if (!ListEquals.listEquals(objectTypeSequence, _that.getObjectTypeSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (encoding != null ? encoding.hashCode() : 0);
			_result = 31 * _result + (objectTypeSequence != null ? objectTypeSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectTypeBuilder {" +
				"id=" + this.id + ", " +
				"mimeType=" + this.mimeType + ", " +
				"encoding=" + this.encoding + ", " +
				"objectTypeSequence=" + this.objectTypeSequence +
			'}';
		}
	}
}
