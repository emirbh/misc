package iso20022.dtcc.rds.harmonized;

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
import iso20022.dtcc.rds.harmonized.meta.DataSubmissionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DataSubmission", builder=DataSubmission.DataSubmissionBuilderImpl.class, version="${project.version}")
@RuneDataType(value="DataSubmission", model="iso20022", builder=DataSubmission.DataSubmissionBuilderImpl.class, version="${project.version}")
public interface DataSubmission extends RosettaModelObject {

	DataSubmissionMeta metaData = new DataSubmissionMeta();

	/*********************** Getter Methods  ***********************/
	Header getHeader();
	Core getCore();
	HarmonizedData getHarmonizedData();
	HarmonizedRepeatableData getHarmonizedRepeatableData();
	Schedules getSchedules();
	List<? extends GenericAttribute> getGenericAttribute();

	/*********************** Build Methods  ***********************/
	DataSubmission build();
	
	DataSubmission.DataSubmissionBuilder toBuilder();
	
	static DataSubmission.DataSubmissionBuilder builder() {
		return new DataSubmission.DataSubmissionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DataSubmission> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DataSubmission> getType() {
		return DataSubmission.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("header"), processor, Header.class, getHeader());
		processRosetta(path.newSubPath("core"), processor, Core.class, getCore());
		processRosetta(path.newSubPath("harmonizedData"), processor, HarmonizedData.class, getHarmonizedData());
		processRosetta(path.newSubPath("harmonizedRepeatableData"), processor, HarmonizedRepeatableData.class, getHarmonizedRepeatableData());
		processRosetta(path.newSubPath("schedules"), processor, Schedules.class, getSchedules());
		processRosetta(path.newSubPath("genericAttribute"), processor, GenericAttribute.class, getGenericAttribute());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DataSubmissionBuilder extends DataSubmission, RosettaModelObjectBuilder {
		Header.HeaderBuilder getOrCreateHeader();
		@Override
		Header.HeaderBuilder getHeader();
		Core.CoreBuilder getOrCreateCore();
		@Override
		Core.CoreBuilder getCore();
		HarmonizedData.HarmonizedDataBuilder getOrCreateHarmonizedData();
		@Override
		HarmonizedData.HarmonizedDataBuilder getHarmonizedData();
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder getOrCreateHarmonizedRepeatableData();
		@Override
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder getHarmonizedRepeatableData();
		Schedules.SchedulesBuilder getOrCreateSchedules();
		@Override
		Schedules.SchedulesBuilder getSchedules();
		GenericAttribute.GenericAttributeBuilder getOrCreateGenericAttribute(int index);
		@Override
		List<? extends GenericAttribute.GenericAttributeBuilder> getGenericAttribute();
		DataSubmission.DataSubmissionBuilder setHeader(Header header);
		DataSubmission.DataSubmissionBuilder setCore(Core core);
		DataSubmission.DataSubmissionBuilder setHarmonizedData(HarmonizedData harmonizedData);
		DataSubmission.DataSubmissionBuilder setHarmonizedRepeatableData(HarmonizedRepeatableData harmonizedRepeatableData);
		DataSubmission.DataSubmissionBuilder setSchedules(Schedules schedules);
		DataSubmission.DataSubmissionBuilder addGenericAttribute(GenericAttribute genericAttribute);
		DataSubmission.DataSubmissionBuilder addGenericAttribute(GenericAttribute genericAttribute, int idx);
		DataSubmission.DataSubmissionBuilder addGenericAttribute(List<? extends GenericAttribute> genericAttribute);
		DataSubmission.DataSubmissionBuilder setGenericAttribute(List<? extends GenericAttribute> genericAttribute);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("header"), processor, Header.HeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("core"), processor, Core.CoreBuilder.class, getCore());
			processRosetta(path.newSubPath("harmonizedData"), processor, HarmonizedData.HarmonizedDataBuilder.class, getHarmonizedData());
			processRosetta(path.newSubPath("harmonizedRepeatableData"), processor, HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder.class, getHarmonizedRepeatableData());
			processRosetta(path.newSubPath("schedules"), processor, Schedules.SchedulesBuilder.class, getSchedules());
			processRosetta(path.newSubPath("genericAttribute"), processor, GenericAttribute.GenericAttributeBuilder.class, getGenericAttribute());
		}
		

		DataSubmission.DataSubmissionBuilder prune();
	}

	/*********************** Immutable Implementation of DataSubmission  ***********************/
	class DataSubmissionImpl implements DataSubmission {
		private final Header header;
		private final Core core;
		private final HarmonizedData harmonizedData;
		private final HarmonizedRepeatableData harmonizedRepeatableData;
		private final Schedules schedules;
		private final List<? extends GenericAttribute> genericAttribute;
		
		protected DataSubmissionImpl(DataSubmission.DataSubmissionBuilder builder) {
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.core = ofNullable(builder.getCore()).map(f->f.build()).orElse(null);
			this.harmonizedData = ofNullable(builder.getHarmonizedData()).map(f->f.build()).orElse(null);
			this.harmonizedRepeatableData = ofNullable(builder.getHarmonizedRepeatableData()).map(f->f.build()).orElse(null);
			this.schedules = ofNullable(builder.getSchedules()).map(f->f.build()).orElse(null);
			this.genericAttribute = ofNullable(builder.getGenericAttribute()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("header")
		public Header getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("core")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("core")
		public Core getCore() {
			return core;
		}
		
		@Override
		@RosettaAttribute("harmonizedData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("harmonizedData")
		public HarmonizedData getHarmonizedData() {
			return harmonizedData;
		}
		
		@Override
		@RosettaAttribute("harmonizedRepeatableData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("harmonizedRepeatableData")
		public HarmonizedRepeatableData getHarmonizedRepeatableData() {
			return harmonizedRepeatableData;
		}
		
		@Override
		@RosettaAttribute("schedules")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("schedules")
		public Schedules getSchedules() {
			return schedules;
		}
		
		@Override
		@RosettaAttribute("genericAttribute")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("genericAttribute")
		public List<? extends GenericAttribute> getGenericAttribute() {
			return genericAttribute;
		}
		
		@Override
		public DataSubmission build() {
			return this;
		}
		
		@Override
		public DataSubmission.DataSubmissionBuilder toBuilder() {
			DataSubmission.DataSubmissionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DataSubmission.DataSubmissionBuilder builder) {
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getCore()).ifPresent(builder::setCore);
			ofNullable(getHarmonizedData()).ifPresent(builder::setHarmonizedData);
			ofNullable(getHarmonizedRepeatableData()).ifPresent(builder::setHarmonizedRepeatableData);
			ofNullable(getSchedules()).ifPresent(builder::setSchedules);
			ofNullable(getGenericAttribute()).ifPresent(builder::setGenericAttribute);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DataSubmission _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(core, _that.getCore())) return false;
			if (!Objects.equals(harmonizedData, _that.getHarmonizedData())) return false;
			if (!Objects.equals(harmonizedRepeatableData, _that.getHarmonizedRepeatableData())) return false;
			if (!Objects.equals(schedules, _that.getSchedules())) return false;
			if (!ListEquals.listEquals(genericAttribute, _that.getGenericAttribute())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (core != null ? core.hashCode() : 0);
			_result = 31 * _result + (harmonizedData != null ? harmonizedData.hashCode() : 0);
			_result = 31 * _result + (harmonizedRepeatableData != null ? harmonizedRepeatableData.hashCode() : 0);
			_result = 31 * _result + (schedules != null ? schedules.hashCode() : 0);
			_result = 31 * _result + (genericAttribute != null ? genericAttribute.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataSubmission {" +
				"header=" + this.header + ", " +
				"core=" + this.core + ", " +
				"harmonizedData=" + this.harmonizedData + ", " +
				"harmonizedRepeatableData=" + this.harmonizedRepeatableData + ", " +
				"schedules=" + this.schedules + ", " +
				"genericAttribute=" + this.genericAttribute +
			'}';
		}
	}

	/*********************** Builder Implementation of DataSubmission  ***********************/
	class DataSubmissionBuilderImpl implements DataSubmission.DataSubmissionBuilder {
	
		protected Header.HeaderBuilder header;
		protected Core.CoreBuilder core;
		protected HarmonizedData.HarmonizedDataBuilder harmonizedData;
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonizedRepeatableData;
		protected Schedules.SchedulesBuilder schedules;
		protected List<GenericAttribute.GenericAttributeBuilder> genericAttribute = new ArrayList<>();
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("header")
		public Header.HeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public Header.HeaderBuilder getOrCreateHeader() {
			Header.HeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = Header.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("core")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("core")
		public Core.CoreBuilder getCore() {
			return core;
		}
		
		@Override
		public Core.CoreBuilder getOrCreateCore() {
			Core.CoreBuilder result;
			if (core!=null) {
				result = core;
			}
			else {
				result = core = Core.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("harmonizedData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("harmonizedData")
		public HarmonizedData.HarmonizedDataBuilder getHarmonizedData() {
			return harmonizedData;
		}
		
		@Override
		public HarmonizedData.HarmonizedDataBuilder getOrCreateHarmonizedData() {
			HarmonizedData.HarmonizedDataBuilder result;
			if (harmonizedData!=null) {
				result = harmonizedData;
			}
			else {
				result = harmonizedData = HarmonizedData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("harmonizedRepeatableData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("harmonizedRepeatableData")
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder getHarmonizedRepeatableData() {
			return harmonizedRepeatableData;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder getOrCreateHarmonizedRepeatableData() {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder result;
			if (harmonizedRepeatableData!=null) {
				result = harmonizedRepeatableData;
			}
			else {
				result = harmonizedRepeatableData = HarmonizedRepeatableData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("schedules")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("schedules")
		public Schedules.SchedulesBuilder getSchedules() {
			return schedules;
		}
		
		@Override
		public Schedules.SchedulesBuilder getOrCreateSchedules() {
			Schedules.SchedulesBuilder result;
			if (schedules!=null) {
				result = schedules;
			}
			else {
				result = schedules = Schedules.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("genericAttribute")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("genericAttribute")
		public List<? extends GenericAttribute.GenericAttributeBuilder> getGenericAttribute() {
			return genericAttribute;
		}
		
		@Override
		public GenericAttribute.GenericAttributeBuilder getOrCreateGenericAttribute(int index) {
			if (genericAttribute==null) {
				this.genericAttribute = new ArrayList<>();
			}
			return getIndex(genericAttribute, index, () -> {
						GenericAttribute.GenericAttributeBuilder newGenericAttribute = GenericAttribute.builder();
						return newGenericAttribute;
					});
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("header")
		@Override
		public DataSubmission.DataSubmissionBuilder setHeader(Header _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("core")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("core")
		@Override
		public DataSubmission.DataSubmissionBuilder setCore(Core _core) {
			this.core = _core == null ? null : _core.toBuilder();
			return this;
		}
		
		@RosettaAttribute("harmonizedData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("harmonizedData")
		@Override
		public DataSubmission.DataSubmissionBuilder setHarmonizedData(HarmonizedData _harmonizedData) {
			this.harmonizedData = _harmonizedData == null ? null : _harmonizedData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("harmonizedRepeatableData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("harmonizedRepeatableData")
		@Override
		public DataSubmission.DataSubmissionBuilder setHarmonizedRepeatableData(HarmonizedRepeatableData _harmonizedRepeatableData) {
			this.harmonizedRepeatableData = _harmonizedRepeatableData == null ? null : _harmonizedRepeatableData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("schedules")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("schedules")
		@Override
		public DataSubmission.DataSubmissionBuilder setSchedules(Schedules _schedules) {
			this.schedules = _schedules == null ? null : _schedules.toBuilder();
			return this;
		}
		
		@RosettaAttribute("genericAttribute")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("genericAttribute")
		@Override
		public DataSubmission.DataSubmissionBuilder addGenericAttribute(GenericAttribute _genericAttribute) {
			if (_genericAttribute != null) {
				this.genericAttribute.add(_genericAttribute.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataSubmission.DataSubmissionBuilder addGenericAttribute(GenericAttribute _genericAttribute, int idx) {
			getIndex(this.genericAttribute, idx, () -> _genericAttribute.toBuilder());
			return this;
		}
		
		@Override
		public DataSubmission.DataSubmissionBuilder addGenericAttribute(List<? extends GenericAttribute> genericAttributes) {
			if (genericAttributes != null) {
				for (final GenericAttribute toAdd : genericAttributes) {
					this.genericAttribute.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("genericAttribute")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("genericAttribute")
		@Override
		public DataSubmission.DataSubmissionBuilder setGenericAttribute(List<? extends GenericAttribute> genericAttributes) {
			if (genericAttributes == null) {
				this.genericAttribute = new ArrayList<>();
			} else {
				this.genericAttribute = genericAttributes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DataSubmission build() {
			return new DataSubmission.DataSubmissionImpl(this);
		}
		
		@Override
		public DataSubmission.DataSubmissionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataSubmission.DataSubmissionBuilder prune() {
			if (header!=null && !header.prune().hasData()) header = null;
			if (core!=null && !core.prune().hasData()) core = null;
			if (harmonizedData!=null && !harmonizedData.prune().hasData()) harmonizedData = null;
			if (harmonizedRepeatableData!=null && !harmonizedRepeatableData.prune().hasData()) harmonizedRepeatableData = null;
			if (schedules!=null && !schedules.prune().hasData()) schedules = null;
			genericAttribute = genericAttribute.stream().filter(b->b!=null).<GenericAttribute.GenericAttributeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getCore()!=null && getCore().hasData()) return true;
			if (getHarmonizedData()!=null && getHarmonizedData().hasData()) return true;
			if (getHarmonizedRepeatableData()!=null && getHarmonizedRepeatableData().hasData()) return true;
			if (getSchedules()!=null && getSchedules().hasData()) return true;
			if (getGenericAttribute()!=null && getGenericAttribute().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataSubmission.DataSubmissionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DataSubmission.DataSubmissionBuilder o = (DataSubmission.DataSubmissionBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getCore(), o.getCore(), this::setCore);
			merger.mergeRosetta(getHarmonizedData(), o.getHarmonizedData(), this::setHarmonizedData);
			merger.mergeRosetta(getHarmonizedRepeatableData(), o.getHarmonizedRepeatableData(), this::setHarmonizedRepeatableData);
			merger.mergeRosetta(getSchedules(), o.getSchedules(), this::setSchedules);
			merger.mergeRosetta(getGenericAttribute(), o.getGenericAttribute(), this::getOrCreateGenericAttribute);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DataSubmission _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(core, _that.getCore())) return false;
			if (!Objects.equals(harmonizedData, _that.getHarmonizedData())) return false;
			if (!Objects.equals(harmonizedRepeatableData, _that.getHarmonizedRepeatableData())) return false;
			if (!Objects.equals(schedules, _that.getSchedules())) return false;
			if (!ListEquals.listEquals(genericAttribute, _that.getGenericAttribute())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (core != null ? core.hashCode() : 0);
			_result = 31 * _result + (harmonizedData != null ? harmonizedData.hashCode() : 0);
			_result = 31 * _result + (harmonizedRepeatableData != null ? harmonizedRepeatableData.hashCode() : 0);
			_result = 31 * _result + (schedules != null ? schedules.hashCode() : 0);
			_result = 31 * _result + (genericAttribute != null ? genericAttribute.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataSubmissionBuilder {" +
				"header=" + this.header + ", " +
				"core=" + this.core + ", " +
				"harmonizedData=" + this.harmonizedData + ", " +
				"harmonizedRepeatableData=" + this.harmonizedRepeatableData + ", " +
				"schedules=" + this.schedules + ", " +
				"genericAttribute=" + this.genericAttribute +
			'}';
		}
	}
}
