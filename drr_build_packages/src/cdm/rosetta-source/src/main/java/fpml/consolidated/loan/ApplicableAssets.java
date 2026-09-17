package fpml.consolidated.loan;

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
import fpml.consolidated.asset.FacilityType;
import fpml.consolidated.fpmlenum.LoanAllAssetsEnum;
import fpml.consolidated.loan.meta.ApplicableAssetsMeta;
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
 * version "confirmation-5.13"
 *
 * Provision A structure that defines the assets (or type of assets) that a particular payment profile may be associated with.
 *
 */
@RosettaDataType(value="ApplicableAssets", builder=ApplicableAssets.ApplicableAssetsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApplicableAssets", model="fpml", builder=ApplicableAssets.ApplicableAssetsBuilderImpl.class, version="2.1.1")
public interface ApplicableAssets extends RosettaModelObject {

	ApplicableAssetsMeta metaData = new ApplicableAssetsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The deals for which this default settlement instruction is valid.
	 *
	 */
	List<? extends DealIdentifier> getDealIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The facilities for which this default settlement instruction is valid.
	 *
	 */
	List<? extends FacilityIdentifier> getFacilityIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The facility type (i.e. term, delayed draw, TLB, etc.) for which this default settlement instruction is valid.
	 *
	 */
	List<? extends FacilityType> getFacilityType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list with a single 'all' value to explicitly indicate all transactions are applicable.
	 *
	 */
	LoanAllAssetsEnum getAllAssets();

	/*********************** Build Methods  ***********************/
	ApplicableAssets build();
	
	ApplicableAssets.ApplicableAssetsBuilder toBuilder();
	
	static ApplicableAssets.ApplicableAssetsBuilder builder() {
		return new ApplicableAssets.ApplicableAssetsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableAssets> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableAssets> getType() {
		return ApplicableAssets.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilityType"), processor, FacilityType.class, getFacilityType());
		processor.processBasic(path.newSubPath("allAssets"), LoanAllAssetsEnum.class, getAllAssets(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableAssetsBuilder extends ApplicableAssets, RosettaModelObjectBuilder {
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier(int index);
		@Override
		List<? extends DealIdentifier.DealIdentifierBuilder> getDealIdentifier();
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier(int index);
		@Override
		List<? extends FacilityIdentifier.FacilityIdentifierBuilder> getFacilityIdentifier();
		FacilityType.FacilityTypeBuilder getOrCreateFacilityType(int index);
		@Override
		List<? extends FacilityType.FacilityTypeBuilder> getFacilityType();
		ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier dealIdentifier);
		ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier dealIdentifier, int idx);
		ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(List<? extends DealIdentifier> dealIdentifier);
		ApplicableAssets.ApplicableAssetsBuilder setDealIdentifier(List<? extends DealIdentifier> dealIdentifier);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier facilityIdentifier, int idx);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifier);
		ApplicableAssets.ApplicableAssetsBuilder setFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifier);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType facilityType);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType facilityType, int idx);
		ApplicableAssets.ApplicableAssetsBuilder addFacilityType(List<? extends FacilityType> facilityType);
		ApplicableAssets.ApplicableAssetsBuilder setFacilityType(List<? extends FacilityType> facilityType);
		ApplicableAssets.ApplicableAssetsBuilder setAllAssets(LoanAllAssetsEnum allAssets);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilityType"), processor, FacilityType.FacilityTypeBuilder.class, getFacilityType());
			processor.processBasic(path.newSubPath("allAssets"), LoanAllAssetsEnum.class, getAllAssets(), this);
		}
		

		ApplicableAssets.ApplicableAssetsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableAssets  ***********************/
	class ApplicableAssetsImpl implements ApplicableAssets {
		private final List<? extends DealIdentifier> dealIdentifier;
		private final List<? extends FacilityIdentifier> facilityIdentifier;
		private final List<? extends FacilityType> facilityType;
		private final LoanAllAssetsEnum allAssets;
		
		protected ApplicableAssetsImpl(ApplicableAssets.ApplicableAssetsBuilder builder) {
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityType = ofNullable(builder.getFacilityType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.allAssets = builder.getAllAssets();
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealIdentifier")
		public List<? extends DealIdentifier> getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityIdentifier")
		public List<? extends FacilityIdentifier> getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityType")
		public List<? extends FacilityType> getFacilityType() {
			return facilityType;
		}
		
		@Override
		@RosettaAttribute("allAssets")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allAssets")
		public LoanAllAssetsEnum getAllAssets() {
			return allAssets;
		}
		
		@Override
		public ApplicableAssets build() {
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder toBuilder() {
			ApplicableAssets.ApplicableAssetsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableAssets.ApplicableAssetsBuilder builder) {
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilityType()).ifPresent(builder::setFacilityType);
			ofNullable(getAllAssets()).ifPresent(builder::setAllAssets);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableAssets _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!ListEquals.listEquals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(allAssets, _that.getAllAssets())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (allAssets != null ? allAssets.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableAssets {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilityType=" + this.facilityType + ", " +
				"allAssets=" + this.allAssets +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicableAssets  ***********************/
	class ApplicableAssetsBuilderImpl implements ApplicableAssets.ApplicableAssetsBuilder {
	
		protected List<DealIdentifier.DealIdentifierBuilder> dealIdentifier = new ArrayList<>();
		protected List<FacilityIdentifier.FacilityIdentifierBuilder> facilityIdentifier = new ArrayList<>();
		protected List<FacilityType.FacilityTypeBuilder> facilityType = new ArrayList<>();
		protected LoanAllAssetsEnum allAssets;
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dealIdentifier")
		public List<? extends DealIdentifier.DealIdentifierBuilder> getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier(int index) {
			if (dealIdentifier==null) {
				this.dealIdentifier = new ArrayList<>();
			}
			return getIndex(dealIdentifier, index, () -> {
						DealIdentifier.DealIdentifierBuilder newDealIdentifier = DealIdentifier.builder();
						return newDealIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityIdentifier")
		public List<? extends FacilityIdentifier.FacilityIdentifierBuilder> getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier(int index) {
			if (facilityIdentifier==null) {
				this.facilityIdentifier = new ArrayList<>();
			}
			return getIndex(facilityIdentifier, index, () -> {
						FacilityIdentifier.FacilityIdentifierBuilder newFacilityIdentifier = FacilityIdentifier.builder();
						return newFacilityIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("facilityType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityType")
		public List<? extends FacilityType.FacilityTypeBuilder> getFacilityType() {
			return facilityType;
		}
		
		@Override
		public FacilityType.FacilityTypeBuilder getOrCreateFacilityType(int index) {
			if (facilityType==null) {
				this.facilityType = new ArrayList<>();
			}
			return getIndex(facilityType, index, () -> {
						FacilityType.FacilityTypeBuilder newFacilityType = FacilityType.builder();
						return newFacilityType;
					});
		}
		
		@Override
		@RosettaAttribute("allAssets")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allAssets")
		public LoanAllAssetsEnum getAllAssets() {
			return allAssets;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dealIdentifier")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier _dealIdentifier) {
			if (_dealIdentifier != null) {
				this.dealIdentifier.add(_dealIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(DealIdentifier _dealIdentifier, int idx) {
			getIndex(this.dealIdentifier, idx, () -> _dealIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addDealIdentifier(List<? extends DealIdentifier> dealIdentifiers) {
			if (dealIdentifiers != null) {
				for (final DealIdentifier toAdd : dealIdentifiers) {
					this.dealIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dealIdentifier")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder setDealIdentifier(List<? extends DealIdentifier> dealIdentifiers) {
			if (dealIdentifiers == null) {
				this.dealIdentifier = new ArrayList<>();
			} else {
				this.dealIdentifier = dealIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityIdentifier")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			if (_facilityIdentifier != null) {
				this.facilityIdentifier.add(_facilityIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(FacilityIdentifier _facilityIdentifier, int idx) {
			getIndex(this.facilityIdentifier, idx, () -> _facilityIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifiers) {
			if (facilityIdentifiers != null) {
				for (final FacilityIdentifier toAdd : facilityIdentifiers) {
					this.facilityIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityIdentifier")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder setFacilityIdentifier(List<? extends FacilityIdentifier> facilityIdentifiers) {
			if (facilityIdentifiers == null) {
				this.facilityIdentifier = new ArrayList<>();
			} else {
				this.facilityIdentifier = facilityIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityType")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType _facilityType) {
			if (_facilityType != null) {
				this.facilityType.add(_facilityType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityType(FacilityType _facilityType, int idx) {
			getIndex(this.facilityType, idx, () -> _facilityType.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder addFacilityType(List<? extends FacilityType> facilityTypes) {
			if (facilityTypes != null) {
				for (final FacilityType toAdd : facilityTypes) {
					this.facilityType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityType")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder setFacilityType(List<? extends FacilityType> facilityTypes) {
			if (facilityTypes == null) {
				this.facilityType = new ArrayList<>();
			} else {
				this.facilityType = facilityTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("allAssets")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allAssets")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder setAllAssets(LoanAllAssetsEnum _allAssets) {
			this.allAssets = _allAssets == null ? null : _allAssets;
			return this;
		}
		
		@Override
		public ApplicableAssets build() {
			return new ApplicableAssets.ApplicableAssetsImpl(this);
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder prune() {
			dealIdentifier = dealIdentifier.stream().filter(b->b!=null).<DealIdentifier.DealIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityIdentifier = facilityIdentifier.stream().filter(b->b!=null).<FacilityIdentifier.FacilityIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityType = facilityType.stream().filter(b->b!=null).<FacilityType.FacilityTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealIdentifier()!=null && getDealIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityType()!=null && getFacilityType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAllAssets()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableAssets.ApplicableAssetsBuilder o = (ApplicableAssets.ApplicableAssetsBuilder) other;
			
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::getOrCreateDealIdentifier);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::getOrCreateFacilityIdentifier);
			merger.mergeRosetta(getFacilityType(), o.getFacilityType(), this::getOrCreateFacilityType);
			
			merger.mergeBasic(getAllAssets(), o.getAllAssets(), this::setAllAssets);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableAssets _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!ListEquals.listEquals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!ListEquals.listEquals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(allAssets, _that.getAllAssets())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (allAssets != null ? allAssets.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableAssetsBuilder {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilityType=" + this.facilityType + ", " +
				"allAssets=" + this.allAssets +
			'}';
		}
	}
}
