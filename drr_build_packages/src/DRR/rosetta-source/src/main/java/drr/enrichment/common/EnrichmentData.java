package drr.enrichment.common;

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
import drr.enrichment.common.meta.EnrichmentDataMeta;
import drr.enrichment.lei.LeiData;
import drr.enrichment.upi.UpiData;
import drr.standards.iso.MicData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Optionally populated by the pre-enrichment process.
 * @version 7.7.0
 */
@RosettaDataType(value="EnrichmentData", builder=EnrichmentData.EnrichmentDataBuilderImpl.class, version="7.7.0")
@RuneDataType(value="EnrichmentData", model="drr", builder=EnrichmentData.EnrichmentDataBuilderImpl.class, version="7.7.0")
public interface EnrichmentData extends RosettaModelObject {

	EnrichmentDataMeta metaData = new EnrichmentDataMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends MicData> getMicData();
	List<? extends LeiData> getLeiData();
	List<? extends UpiData> getUpiData();

	/*********************** Build Methods  ***********************/
	EnrichmentData build();
	
	EnrichmentData.EnrichmentDataBuilder toBuilder();
	
	static EnrichmentData.EnrichmentDataBuilder builder() {
		return new EnrichmentData.EnrichmentDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnrichmentData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnrichmentData> getType() {
		return EnrichmentData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("micData"), processor, MicData.class, getMicData());
		processRosetta(path.newSubPath("leiData"), processor, LeiData.class, getLeiData());
		processRosetta(path.newSubPath("upiData"), processor, UpiData.class, getUpiData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnrichmentDataBuilder extends EnrichmentData, RosettaModelObjectBuilder {
		MicData.MicDataBuilder getOrCreateMicData(int index);
		@Override
		List<? extends MicData.MicDataBuilder> getMicData();
		LeiData.LeiDataBuilder getOrCreateLeiData(int index);
		@Override
		List<? extends LeiData.LeiDataBuilder> getLeiData();
		UpiData.UpiDataBuilder getOrCreateUpiData(int index);
		@Override
		List<? extends UpiData.UpiDataBuilder> getUpiData();
		EnrichmentData.EnrichmentDataBuilder addMicData(MicData micData);
		EnrichmentData.EnrichmentDataBuilder addMicData(MicData micData, int idx);
		EnrichmentData.EnrichmentDataBuilder addMicData(List<? extends MicData> micData);
		EnrichmentData.EnrichmentDataBuilder setMicData(List<? extends MicData> micData);
		EnrichmentData.EnrichmentDataBuilder addLeiData(LeiData leiData);
		EnrichmentData.EnrichmentDataBuilder addLeiData(LeiData leiData, int idx);
		EnrichmentData.EnrichmentDataBuilder addLeiData(List<? extends LeiData> leiData);
		EnrichmentData.EnrichmentDataBuilder setLeiData(List<? extends LeiData> leiData);
		EnrichmentData.EnrichmentDataBuilder addUpiData(UpiData upiData);
		EnrichmentData.EnrichmentDataBuilder addUpiData(UpiData upiData, int idx);
		EnrichmentData.EnrichmentDataBuilder addUpiData(List<? extends UpiData> upiData);
		EnrichmentData.EnrichmentDataBuilder setUpiData(List<? extends UpiData> upiData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("micData"), processor, MicData.MicDataBuilder.class, getMicData());
			processRosetta(path.newSubPath("leiData"), processor, LeiData.LeiDataBuilder.class, getLeiData());
			processRosetta(path.newSubPath("upiData"), processor, UpiData.UpiDataBuilder.class, getUpiData());
		}
		

		EnrichmentData.EnrichmentDataBuilder prune();
	}

	/*********************** Immutable Implementation of EnrichmentData  ***********************/
	class EnrichmentDataImpl implements EnrichmentData {
		private final List<? extends MicData> micData;
		private final List<? extends LeiData> leiData;
		private final List<? extends UpiData> upiData;
		
		protected EnrichmentDataImpl(EnrichmentData.EnrichmentDataBuilder builder) {
			this.micData = ofNullable(builder.getMicData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.leiData = ofNullable(builder.getLeiData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.upiData = ofNullable(builder.getUpiData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("micData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("micData")
		public List<? extends MicData> getMicData() {
			return micData;
		}
		
		@Override
		@RosettaAttribute("leiData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leiData")
		public List<? extends LeiData> getLeiData() {
			return leiData;
		}
		
		@Override
		@RosettaAttribute("upiData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("upiData")
		public List<? extends UpiData> getUpiData() {
			return upiData;
		}
		
		@Override
		public EnrichmentData build() {
			return this;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder toBuilder() {
			EnrichmentData.EnrichmentDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnrichmentData.EnrichmentDataBuilder builder) {
			ofNullable(getMicData()).ifPresent(builder::setMicData);
			ofNullable(getLeiData()).ifPresent(builder::setLeiData);
			ofNullable(getUpiData()).ifPresent(builder::setUpiData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnrichmentData _that = getType().cast(o);
		
			if (!ListEquals.listEquals(micData, _that.getMicData())) return false;
			if (!ListEquals.listEquals(leiData, _that.getLeiData())) return false;
			if (!ListEquals.listEquals(upiData, _that.getUpiData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (micData != null ? micData.hashCode() : 0);
			_result = 31 * _result + (leiData != null ? leiData.hashCode() : 0);
			_result = 31 * _result + (upiData != null ? upiData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnrichmentData {" +
				"micData=" + this.micData + ", " +
				"leiData=" + this.leiData + ", " +
				"upiData=" + this.upiData +
			'}';
		}
	}

	/*********************** Builder Implementation of EnrichmentData  ***********************/
	class EnrichmentDataBuilderImpl implements EnrichmentData.EnrichmentDataBuilder {
	
		protected List<MicData.MicDataBuilder> micData = new ArrayList<>();
		protected List<LeiData.LeiDataBuilder> leiData = new ArrayList<>();
		protected List<UpiData.UpiDataBuilder> upiData = new ArrayList<>();
		
		@Override
		@RosettaAttribute("micData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("micData")
		public List<? extends MicData.MicDataBuilder> getMicData() {
			return micData;
		}
		
		@Override
		public MicData.MicDataBuilder getOrCreateMicData(int index) {
			if (micData==null) {
				this.micData = new ArrayList<>();
			}
			return getIndex(micData, index, () -> {
						MicData.MicDataBuilder newMicData = MicData.builder();
						return newMicData;
					});
		}
		
		@Override
		@RosettaAttribute("leiData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leiData")
		public List<? extends LeiData.LeiDataBuilder> getLeiData() {
			return leiData;
		}
		
		@Override
		public LeiData.LeiDataBuilder getOrCreateLeiData(int index) {
			if (leiData==null) {
				this.leiData = new ArrayList<>();
			}
			return getIndex(leiData, index, () -> {
						LeiData.LeiDataBuilder newLeiData = LeiData.builder();
						return newLeiData;
					});
		}
		
		@Override
		@RosettaAttribute("upiData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("upiData")
		public List<? extends UpiData.UpiDataBuilder> getUpiData() {
			return upiData;
		}
		
		@Override
		public UpiData.UpiDataBuilder getOrCreateUpiData(int index) {
			if (upiData==null) {
				this.upiData = new ArrayList<>();
			}
			return getIndex(upiData, index, () -> {
						UpiData.UpiDataBuilder newUpiData = UpiData.builder();
						return newUpiData;
					});
		}
		
		@RosettaAttribute("micData")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("micData")
		@Override
		public EnrichmentData.EnrichmentDataBuilder addMicData(MicData _micData) {
			if (_micData != null) {
				this.micData.add(_micData.toBuilder());
			}
			return this;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder addMicData(MicData _micData, int idx) {
			getIndex(this.micData, idx, () -> _micData.toBuilder());
			return this;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder addMicData(List<? extends MicData> micDatas) {
			if (micDatas != null) {
				for (final MicData toAdd : micDatas) {
					this.micData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("micData")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("micData")
		@Override
		public EnrichmentData.EnrichmentDataBuilder setMicData(List<? extends MicData> micDatas) {
			if (micDatas == null) {
				this.micData = new ArrayList<>();
			} else {
				this.micData = micDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leiData")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leiData")
		@Override
		public EnrichmentData.EnrichmentDataBuilder addLeiData(LeiData _leiData) {
			if (_leiData != null) {
				this.leiData.add(_leiData.toBuilder());
			}
			return this;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder addLeiData(LeiData _leiData, int idx) {
			getIndex(this.leiData, idx, () -> _leiData.toBuilder());
			return this;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder addLeiData(List<? extends LeiData> leiDatas) {
			if (leiDatas != null) {
				for (final LeiData toAdd : leiDatas) {
					this.leiData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("leiData")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leiData")
		@Override
		public EnrichmentData.EnrichmentDataBuilder setLeiData(List<? extends LeiData> leiDatas) {
			if (leiDatas == null) {
				this.leiData = new ArrayList<>();
			} else {
				this.leiData = leiDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("upiData")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("upiData")
		@Override
		public EnrichmentData.EnrichmentDataBuilder addUpiData(UpiData _upiData) {
			if (_upiData != null) {
				this.upiData.add(_upiData.toBuilder());
			}
			return this;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder addUpiData(UpiData _upiData, int idx) {
			getIndex(this.upiData, idx, () -> _upiData.toBuilder());
			return this;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder addUpiData(List<? extends UpiData> upiDatas) {
			if (upiDatas != null) {
				for (final UpiData toAdd : upiDatas) {
					this.upiData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("upiData")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("upiData")
		@Override
		public EnrichmentData.EnrichmentDataBuilder setUpiData(List<? extends UpiData> upiDatas) {
			if (upiDatas == null) {
				this.upiData = new ArrayList<>();
			} else {
				this.upiData = upiDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EnrichmentData build() {
			return new EnrichmentData.EnrichmentDataImpl(this);
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnrichmentData.EnrichmentDataBuilder prune() {
			micData = micData.stream().filter(b->b!=null).<MicData.MicDataBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			leiData = leiData.stream().filter(b->b!=null).<LeiData.LeiDataBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			upiData = upiData.stream().filter(b->b!=null).<UpiData.UpiDataBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMicData()!=null && getMicData().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLeiData()!=null && getLeiData().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getUpiData()!=null && getUpiData().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnrichmentData.EnrichmentDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnrichmentData.EnrichmentDataBuilder o = (EnrichmentData.EnrichmentDataBuilder) other;
			
			merger.mergeRosetta(getMicData(), o.getMicData(), this::getOrCreateMicData);
			merger.mergeRosetta(getLeiData(), o.getLeiData(), this::getOrCreateLeiData);
			merger.mergeRosetta(getUpiData(), o.getUpiData(), this::getOrCreateUpiData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnrichmentData _that = getType().cast(o);
		
			if (!ListEquals.listEquals(micData, _that.getMicData())) return false;
			if (!ListEquals.listEquals(leiData, _that.getLeiData())) return false;
			if (!ListEquals.listEquals(upiData, _that.getUpiData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (micData != null ? micData.hashCode() : 0);
			_result = 31 * _result + (leiData != null ? leiData.hashCode() : 0);
			_result = 31 * _result + (upiData != null ? upiData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnrichmentDataBuilder {" +
				"micData=" + this.micData + ", " +
				"leiData=" + this.leiData + ", " +
				"upiData=" + this.upiData +
			'}';
		}
	}
}
