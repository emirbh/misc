package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.IdentifiedAssetMeta;
import fpml.consolidated.shared.InstrumentId;
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
 * Provision A generic type describing an identified asset.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A generic type describing an identified asset.
 *
 */
@RosettaDataType(value="IdentifiedAsset", builder=IdentifiedAsset.IdentifiedAssetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IdentifiedAsset", model="fpml", builder=IdentifiedAsset.IdentifiedAssetBuilderImpl.class, version="2.1.1")
public interface IdentifiedAsset extends Asset {

	IdentifiedAssetMeta metaData = new IdentifiedAssetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the underlying asset, using public and/or private identifiers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the underlying asset, using public and/or private identifiers.
	 *
	 */
	List<? extends InstrumentId> getInstrumentId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the asset, using public and/or private typologies e.g. ISO 10962 CFI code.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Classification of the asset, using public and/or private typologies e.g. ISO 10962 CFI code.
	 *
	 */
	List<? extends InstrumentType> getInstrumentType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Long name of the underlying asset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Long name of the underlying asset.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	IdentifiedAsset build();
	
	IdentifiedAsset.IdentifiedAssetBuilder toBuilder();
	
	static IdentifiedAsset.IdentifiedAssetBuilder builder() {
		return new IdentifiedAsset.IdentifiedAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedAsset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IdentifiedAsset> getType() {
		return IdentifiedAsset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedAssetBuilder extends IdentifiedAsset, Asset.AssetBuilder {
		InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index);
		@Override
		List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId();
		InstrumentType.InstrumentTypeBuilder getOrCreateInstrumentType(int index);
		@Override
		List<? extends InstrumentType.InstrumentTypeBuilder> getInstrumentType();
		@Override
		IdentifiedAsset.IdentifiedAssetBuilder setId(String id);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId instrumentId);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		IdentifiedAsset.IdentifiedAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentType(InstrumentType instrumentType);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		IdentifiedAsset.IdentifiedAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		IdentifiedAsset.IdentifiedAssetBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		IdentifiedAsset.IdentifiedAssetBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedAsset  ***********************/
	class IdentifiedAssetImpl extends Asset.AssetImpl implements IdentifiedAsset {
		private final List<? extends InstrumentId> instrumentId;
		private final List<? extends InstrumentType> instrumentType;
		private final String description;
		
		protected IdentifiedAssetImpl(IdentifiedAsset.IdentifiedAssetBuilder builder) {
			super(builder);
			this.instrumentId = ofNullable(builder.getInstrumentId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.instrumentType = ofNullable(builder.getInstrumentType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentType")
		public List<? extends InstrumentType> getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public IdentifiedAsset build() {
			return this;
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder toBuilder() {
			IdentifiedAsset.IdentifiedAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedAsset.IdentifiedAssetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInstrumentId()).ifPresent(builder::setInstrumentId);
			ofNullable(getInstrumentType()).ifPresent(builder::setInstrumentType);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedAsset _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!ListEquals.listEquals(instrumentType, _that.getInstrumentType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (instrumentType != null ? instrumentType.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedAsset {" +
				"instrumentId=" + this.instrumentId + ", " +
				"instrumentType=" + this.instrumentType + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IdentifiedAsset  ***********************/
	class IdentifiedAssetBuilderImpl extends Asset.AssetBuilderImpl implements IdentifiedAsset.IdentifiedAssetBuilder {
	
		protected List<InstrumentId.InstrumentIdBuilder> instrumentId = new ArrayList<>();
		protected List<InstrumentType.InstrumentTypeBuilder> instrumentType = new ArrayList<>();
		protected String description;
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index) {
			if (instrumentId==null) {
				this.instrumentId = new ArrayList<>();
			}
			return getIndex(instrumentId, index, () -> {
						InstrumentId.InstrumentIdBuilder newInstrumentId = InstrumentId.builder();
						return newInstrumentId;
					});
		}
		
		@Override
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentType")
		public List<? extends InstrumentType.InstrumentTypeBuilder> getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		public InstrumentType.InstrumentTypeBuilder getOrCreateInstrumentType(int index) {
			if (instrumentType==null) {
				this.instrumentType = new ArrayList<>();
			}
			return getIndex(instrumentType, index, () -> {
						InstrumentType.InstrumentTypeBuilder newInstrumentType = InstrumentType.builder();
						return newInstrumentType;
					});
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public IdentifiedAsset build() {
			return new IdentifiedAsset.IdentifiedAssetImpl(this);
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder prune() {
			super.prune();
			instrumentId = instrumentId.stream().filter(b->b!=null).<InstrumentId.InstrumentIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			instrumentType = instrumentType.stream().filter(b->b!=null).<InstrumentType.InstrumentTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInstrumentId()!=null && getInstrumentId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInstrumentType()!=null && getInstrumentType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			IdentifiedAsset.IdentifiedAssetBuilder o = (IdentifiedAsset.IdentifiedAssetBuilder) other;
			
			merger.mergeRosetta(getInstrumentId(), o.getInstrumentId(), this::getOrCreateInstrumentId);
			merger.mergeRosetta(getInstrumentType(), o.getInstrumentType(), this::getOrCreateInstrumentType);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedAsset _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!ListEquals.listEquals(instrumentType, _that.getInstrumentType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (instrumentType != null ? instrumentType.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedAssetBuilder {" +
				"instrumentId=" + this.instrumentId + ", " +
				"instrumentType=" + this.instrumentType + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
