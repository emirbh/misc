package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.ESMAProductUnderlyerMeta;
import fpml.consolidated.shared.InstrumentId;
import java.time.ZonedDateTime;
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
 */
@RosettaDataType(value="ESMAProductUnderlyer", builder=ESMAProductUnderlyer.ESMAProductUnderlyerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ESMAProductUnderlyer", model="fpml", builder=ESMAProductUnderlyer.ESMAProductUnderlyerBuilderImpl.class, version="2.1.1")
public interface ESMAProductUnderlyer extends RosettaModelObject {

	ESMAProductUnderlyerMeta metaData = new ESMAProductUnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends InstrumentId> getInstrumentId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ESMAIndexIdentification getIndex();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ZonedDateTime getMaturityDate();

	/*********************** Build Methods  ***********************/
	ESMAProductUnderlyer build();
	
	ESMAProductUnderlyer.ESMAProductUnderlyerBuilder toBuilder();
	
	static ESMAProductUnderlyer.ESMAProductUnderlyerBuilder builder() {
		return new ESMAProductUnderlyer.ESMAProductUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMAProductUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMAProductUnderlyer> getType() {
		return ESMAProductUnderlyer.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("index"), processor, ESMAIndexIdentification.class, getIndex());
		processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMAProductUnderlyerBuilder extends ESMAProductUnderlyer, RosettaModelObjectBuilder {
		InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index);
		@Override
		List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId();
		ESMAIndexIdentification.ESMAIndexIdentificationBuilder getOrCreateIndex();
		@Override
		ESMAIndexIdentification.ESMAIndexIdentificationBuilder getIndex();
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder addInstrumentId(InstrumentId instrumentId);
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder setIndex(ESMAIndexIdentification index);
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder setMaturityDate(ZonedDateTime maturityDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("index"), processor, ESMAIndexIdentification.ESMAIndexIdentificationBuilder.class, getIndex());
			processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
		}
		

		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of ESMAProductUnderlyer  ***********************/
	class ESMAProductUnderlyerImpl implements ESMAProductUnderlyer {
		private final List<? extends InstrumentId> instrumentId;
		private final ESMAIndexIdentification index;
		private final ZonedDateTime maturityDate;
		
		protected ESMAProductUnderlyerImpl(ESMAProductUnderlyer.ESMAProductUnderlyerBuilder builder) {
			this.instrumentId = ofNullable(builder.getInstrumentId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.index = ofNullable(builder.getIndex()).map(f->f.build()).orElse(null);
			this.maturityDate = builder.getMaturityDate();
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		@RosettaAttribute("index")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("index")
		public ESMAIndexIdentification getIndex() {
			return index;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		public ESMAProductUnderlyer build() {
			return this;
		}
		
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder toBuilder() {
			ESMAProductUnderlyer.ESMAProductUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMAProductUnderlyer.ESMAProductUnderlyerBuilder builder) {
			ofNullable(getInstrumentId()).ifPresent(builder::setInstrumentId);
			ofNullable(getIndex()).ifPresent(builder::setIndex);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAProductUnderlyer _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAProductUnderlyer {" +
				"instrumentId=" + this.instrumentId + ", " +
				"index=" + this.index + ", " +
				"maturityDate=" + this.maturityDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMAProductUnderlyer  ***********************/
	class ESMAProductUnderlyerBuilderImpl implements ESMAProductUnderlyer.ESMAProductUnderlyerBuilder {
	
		protected List<InstrumentId.InstrumentIdBuilder> instrumentId = new ArrayList<>();
		protected ESMAIndexIdentification.ESMAIndexIdentificationBuilder index;
		protected ZonedDateTime maturityDate;
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int _index) {
			if (instrumentId==null) {
				this.instrumentId = new ArrayList<>();
			}
			return getIndex(instrumentId, _index, () -> {
						InstrumentId.InstrumentIdBuilder newInstrumentId = InstrumentId.builder();
						return newInstrumentId;
					});
		}
		
		@Override
		@RosettaAttribute("index")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("index")
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder getIndex() {
			return index;
		}
		
		@Override
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder getOrCreateIndex() {
			ESMAIndexIdentification.ESMAIndexIdentificationBuilder result;
			if (index!=null) {
				result = index;
			}
			else {
				result = index = ESMAIndexIdentification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("index")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("index")
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder setIndex(ESMAIndexIdentification _index) {
			this.index = _index == null ? null : _index.toBuilder();
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@Override
		public ESMAProductUnderlyer build() {
			return new ESMAProductUnderlyer.ESMAProductUnderlyerImpl(this);
		}
		
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder prune() {
			instrumentId = instrumentId.stream().filter(b->b!=null).<InstrumentId.InstrumentIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (index!=null && !index.prune().hasData()) index = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInstrumentId()!=null && getInstrumentId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIndex()!=null && getIndex().hasData()) return true;
			if (getMaturityDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMAProductUnderlyer.ESMAProductUnderlyerBuilder o = (ESMAProductUnderlyer.ESMAProductUnderlyerBuilder) other;
			
			merger.mergeRosetta(getInstrumentId(), o.getInstrumentId(), this::getOrCreateInstrumentId);
			merger.mergeRosetta(getIndex(), o.getIndex(), this::setIndex);
			
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAProductUnderlyer _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAProductUnderlyerBuilder {" +
				"instrumentId=" + this.instrumentId + ", " +
				"index=" + this.index + ", " +
				"maturityDate=" + this.maturityDate +
			'}';
		}
	}
}
