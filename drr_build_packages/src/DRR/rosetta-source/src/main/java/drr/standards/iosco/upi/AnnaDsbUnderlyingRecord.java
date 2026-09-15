package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbUnderlyingRecordMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUnderlyingRecord", builder=AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUnderlyingRecord", model="drr", builder=AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUnderlyingRecord extends RosettaModelObject {

	AnnaDsbUnderlyingRecordMeta metaData = new AnnaDsbUnderlyingRecordMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	String getUnderlierID();
	List<String> getReturnUnderlierID();
	AnnaDsbReturnUnderlierIDSourceEnum getReturnUnderlierIDSource();

	/*********************** Build Methods  ***********************/
	AnnaDsbUnderlyingRecord build();
	
	AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder toBuilder();
	
	static AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder builder() {
		return new AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUnderlyingRecord> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUnderlyingRecord> getType() {
		return AnnaDsbUnderlyingRecord.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		processor.processBasic(path.newSubPath("ReturnUnderlierID"), String.class, getReturnUnderlierID(), this);
		processor.processBasic(path.newSubPath("ReturnUnderlierIDSource"), AnnaDsbReturnUnderlierIDSourceEnum.class, getReturnUnderlierIDSource(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUnderlyingRecordBuilder extends AnnaDsbUnderlyingRecord, RosettaModelObjectBuilder {
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setUnderlierID(String UnderlierID);
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder addReturnUnderlierID(String ReturnUnderlierID);
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder addReturnUnderlierID(String ReturnUnderlierID, int idx);
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder addReturnUnderlierID(List<String> ReturnUnderlierID);
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setReturnUnderlierID(List<String> ReturnUnderlierID);
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setReturnUnderlierIDSource(AnnaDsbReturnUnderlierIDSourceEnum ReturnUnderlierIDSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
			processor.processBasic(path.newSubPath("ReturnUnderlierID"), String.class, getReturnUnderlierID(), this);
			processor.processBasic(path.newSubPath("ReturnUnderlierIDSource"), AnnaDsbReturnUnderlierIDSourceEnum.class, getReturnUnderlierIDSource(), this);
		}
		

		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUnderlyingRecord  ***********************/
	class AnnaDsbUnderlyingRecordImpl implements AnnaDsbUnderlyingRecord {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final String underlierID;
		private final List<String> returnUnderlierID;
		private final AnnaDsbReturnUnderlierIDSourceEnum returnUnderlierIDSource;
		
		protected AnnaDsbUnderlyingRecordImpl(AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder builder) {
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.underlierID = builder.getUnderlierID();
			this.returnUnderlierID = ofNullable(builder.getReturnUnderlierID()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.returnUnderlierIDSource = builder.getReturnUnderlierIDSource();
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		@RosettaAttribute("ReturnUnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("ReturnUnderlierID")
		public List<String> getReturnUnderlierID() {
			return returnUnderlierID;
		}
		
		@Override
		@RosettaAttribute("ReturnUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ReturnUnderlierIDSource")
		public AnnaDsbReturnUnderlierIDSourceEnum getReturnUnderlierIDSource() {
			return returnUnderlierIDSource;
		}
		
		@Override
		public AnnaDsbUnderlyingRecord build() {
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder toBuilder() {
			AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder builder) {
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
			ofNullable(getReturnUnderlierID()).ifPresent(builder::setReturnUnderlierID);
			ofNullable(getReturnUnderlierIDSource()).ifPresent(builder::setReturnUnderlierIDSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingRecord _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!ListEquals.listEquals(returnUnderlierID, _that.getReturnUnderlierID())) return false;
			if (!Objects.equals(returnUnderlierIDSource, _that.getReturnUnderlierIDSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (returnUnderlierID != null ? returnUnderlierID.hashCode() : 0);
			_result = 31 * _result + (returnUnderlierIDSource != null ? returnUnderlierIDSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingRecord {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"ReturnUnderlierID=" + this.returnUnderlierID + ", " +
				"ReturnUnderlierIDSource=" + this.returnUnderlierIDSource +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUnderlyingRecord  ***********************/
	class AnnaDsbUnderlyingRecordBuilderImpl implements AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder {
	
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected String underlierID;
		protected List<String> returnUnderlierID = new ArrayList<>();
		protected AnnaDsbReturnUnderlierIDSourceEnum returnUnderlierIDSource;
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		@RosettaAttribute("ReturnUnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("ReturnUnderlierID")
		public List<String> getReturnUnderlierID() {
			return returnUnderlierID;
		}
		
		@Override
		@RosettaAttribute("ReturnUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ReturnUnderlierIDSource")
		public AnnaDsbReturnUnderlierIDSourceEnum getReturnUnderlierIDSource() {
			return returnUnderlierIDSource;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@RosettaAttribute("ReturnUnderlierID")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("ReturnUnderlierID")
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder addReturnUnderlierID(String _returnUnderlierID) {
			if (_returnUnderlierID != null) {
				this.returnUnderlierID.add(_returnUnderlierID);
			}
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder addReturnUnderlierID(String _returnUnderlierID, int idx) {
			getIndex(this.returnUnderlierID, idx, () -> _returnUnderlierID);
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder addReturnUnderlierID(List<String> returnUnderlierIDs) {
			if (returnUnderlierIDs != null) {
				for (final String toAdd : returnUnderlierIDs) {
					this.returnUnderlierID.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("ReturnUnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("ReturnUnderlierID")
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setReturnUnderlierID(List<String> returnUnderlierIDs) {
			if (returnUnderlierIDs == null) {
				this.returnUnderlierID = new ArrayList<>();
			} else {
				this.returnUnderlierID = returnUnderlierIDs.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("ReturnUnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ReturnUnderlierIDSource")
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder setReturnUnderlierIDSource(AnnaDsbReturnUnderlierIDSourceEnum _returnUnderlierIDSource) {
			this.returnUnderlierIDSource = _returnUnderlierIDSource == null ? null : _returnUnderlierIDSource;
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingRecord build() {
			return new AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordImpl(this);
		}
		
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlierIDSource()!=null) return true;
			if (getUnderlierID()!=null) return true;
			if (getReturnUnderlierID()!=null && !getReturnUnderlierID().isEmpty()) return true;
			if (getReturnUnderlierIDSource()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder o = (AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			merger.mergeBasic(getReturnUnderlierID(), o.getReturnUnderlierID(), (Consumer<String>) this::addReturnUnderlierID);
			merger.mergeBasic(getReturnUnderlierIDSource(), o.getReturnUnderlierIDSource(), this::setReturnUnderlierIDSource);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingRecord _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!ListEquals.listEquals(returnUnderlierID, _that.getReturnUnderlierID())) return false;
			if (!Objects.equals(returnUnderlierIDSource, _that.getReturnUnderlierIDSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (returnUnderlierID != null ? returnUnderlierID.hashCode() : 0);
			_result = 31 * _result + (returnUnderlierIDSource != null ? returnUnderlierIDSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingRecordBuilder {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"ReturnUnderlierID=" + this.returnUnderlierID + ", " +
				"ReturnUnderlierIDSource=" + this.returnUnderlierIDSource +
			'}';
		}
	}
}
