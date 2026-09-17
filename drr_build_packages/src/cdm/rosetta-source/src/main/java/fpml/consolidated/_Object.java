package fpml.consolidated;

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
import fpml.consolidated.meta._ObjectMeta;
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
@RosettaDataType(value="_Object", builder=_Object._ObjectBuilderImpl.class, version="2.1.1")
@RuneDataType(value="_Object", model="fpml", builder=_Object._ObjectBuilderImpl.class, version="2.1.1")
public interface _Object extends ObjectType {

	_ObjectMeta metaData = new _ObjectMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	_Object build();
	
	_Object._ObjectBuilder toBuilder();
	
	static _Object._ObjectBuilder builder() {
		return new _Object._ObjectBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends _Object> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends _Object> getType() {
		return _Object.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
		processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
		processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.class, getObjectTypeSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface _ObjectBuilder extends _Object, ObjectType.ObjectTypeBuilder {
		@Override
		_Object._ObjectBuilder setId(String id);
		@Override
		_Object._ObjectBuilder setMimeType(String mimeType);
		@Override
		_Object._ObjectBuilder setEncoding(String encoding);
		@Override
		_Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence);
		@Override
		_Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence objectTypeSequence, int idx);
		@Override
		_Object._ObjectBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence);
		@Override
		_Object._ObjectBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("mimeType"), String.class, getMimeType(), this);
			processor.processBasic(path.newSubPath("encoding"), String.class, getEncoding(), this);
			processRosetta(path.newSubPath("objectTypeSequence"), processor, ObjectTypeSequence.ObjectTypeSequenceBuilder.class, getObjectTypeSequence());
		}
		

		_Object._ObjectBuilder prune();
	}

	/*********************** Immutable Implementation of _Object  ***********************/
	class _ObjectImpl extends ObjectType.ObjectTypeImpl implements _Object {
		
		protected _ObjectImpl(_Object._ObjectBuilder builder) {
			super(builder);
		}
		
		@Override
		public _Object build() {
			return this;
		}
		
		@Override
		public _Object._ObjectBuilder toBuilder() {
			_Object._ObjectBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(_Object._ObjectBuilder builder) {
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
			return "_Object {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of _Object  ***********************/
	class _ObjectBuilderImpl extends ObjectType.ObjectTypeBuilderImpl implements _Object._ObjectBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public _Object._ObjectBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("mimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mimeType")
		@Override
		public _Object._ObjectBuilder setMimeType(String _mimeType) {
			this.mimeType = _mimeType == null ? null : _mimeType;
			return this;
		}
		
		@RosettaAttribute("encoding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("encoding")
		@Override
		public _Object._ObjectBuilder setEncoding(String _encoding) {
			this.encoding = _encoding == null ? null : _encoding;
			return this;
		}
		
		@RosettaAttribute("objectTypeSequence")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("objectTypeSequence")
		@Override
		public _Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence _objectTypeSequence) {
			if (_objectTypeSequence != null) {
				this.objectTypeSequence.add(_objectTypeSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public _Object._ObjectBuilder addObjectTypeSequence(ObjectTypeSequence _objectTypeSequence, int idx) {
			getIndex(this.objectTypeSequence, idx, () -> _objectTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public _Object._ObjectBuilder addObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
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
		public _Object._ObjectBuilder setObjectTypeSequence(List<? extends ObjectTypeSequence> objectTypeSequences) {
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
		public _Object build() {
			return new _Object._ObjectImpl(this);
		}
		
		@Override
		public _Object._ObjectBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public _Object._ObjectBuilder prune() {
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
		public _Object._ObjectBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			_Object._ObjectBuilder o = (_Object._ObjectBuilder) other;
			
			
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
			return "_ObjectBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
