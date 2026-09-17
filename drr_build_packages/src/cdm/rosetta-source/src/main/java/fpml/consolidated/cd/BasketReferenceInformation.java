package fpml.consolidated.cd;

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
import fpml.consolidated.asset.BasketId;
import fpml.consolidated.asset.BasketName;
import fpml.consolidated.cd.meta.BasketReferenceInformationMeta;
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
 * Provision CDS Basket Reference Information
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision CDS Basket Reference Information
 *
 */
@RosettaDataType(value="BasketReferenceInformation", builder=BasketReferenceInformation.BasketReferenceInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BasketReferenceInformation", model="fpml", builder=BasketReferenceInformation.BasketReferenceInformationBuilderImpl.class, version="2.1.1")
public interface BasketReferenceInformation extends RosettaModelObject {

	BasketReferenceInformationMeta metaData = new BasketReferenceInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the basket expressed as a free format string. FpML does not define usage rules for this element.
	 *
	 */
	BasketName getBasketName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A basket identifier
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A basket identifier
	 *
	 */
	List<? extends BasketId> getBasketId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the reference pool items to define the reference entity and reference obligation(s) in the basket
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the reference pool items to define the reference entity and reference obligation(s) in the basket
	 *
	 */
	ReferencePool getReferencePool();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision N th reference obligation to default triggers payout.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision N th reference obligation to default triggers payout.
	 *
	 */
	Integer getNthToDefault();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision M th reference obligation to default to allow representation of N th to M th defaults.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision M th reference obligation to default to allow representation of N th to M th defaults.
	 *
	 */
	Integer getMthToDefault();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains CDS tranche terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains CDS tranche terms.
	 *
	 */
	Tranche getTranche();

	/*********************** Build Methods  ***********************/
	BasketReferenceInformation build();
	
	BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder();
	
	static BasketReferenceInformation.BasketReferenceInformationBuilder builder() {
		return new BasketReferenceInformation.BasketReferenceInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketReferenceInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketReferenceInformation> getType() {
		return BasketReferenceInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketName"), processor, BasketName.class, getBasketName());
		processRosetta(path.newSubPath("basketId"), processor, BasketId.class, getBasketId());
		processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.class, getReferencePool());
		processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
		processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketReferenceInformationBuilder extends BasketReferenceInformation, RosettaModelObjectBuilder {
		BasketName.BasketNameBuilder getOrCreateBasketName();
		@Override
		BasketName.BasketNameBuilder getBasketName();
		BasketId.BasketIdBuilder getOrCreateBasketId(int index);
		@Override
		List<? extends BasketId.BasketIdBuilder> getBasketId();
		ReferencePool.ReferencePoolBuilder getOrCreateReferencePool();
		@Override
		ReferencePool.ReferencePoolBuilder getReferencePool();
		Tranche.TrancheBuilder getOrCreateTranche();
		@Override
		Tranche.TrancheBuilder getTranche();
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketName(BasketName basketName);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(BasketId basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(BasketId basketId, int idx);
		BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(List<? extends BasketId> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setBasketId(List<? extends BasketId> basketId);
		BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool referencePool);
		BasketReferenceInformation.BasketReferenceInformationBuilder setNthToDefault(Integer nthToDefault);
		BasketReferenceInformation.BasketReferenceInformationBuilder setMthToDefault(Integer mthToDefault);
		BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche tranche);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketName"), processor, BasketName.BasketNameBuilder.class, getBasketName());
			processRosetta(path.newSubPath("basketId"), processor, BasketId.BasketIdBuilder.class, getBasketId());
			processRosetta(path.newSubPath("referencePool"), processor, ReferencePool.ReferencePoolBuilder.class, getReferencePool());
			processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
			processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
		}
		

		BasketReferenceInformation.BasketReferenceInformationBuilder prune();
	}

	/*********************** Immutable Implementation of BasketReferenceInformation  ***********************/
	class BasketReferenceInformationImpl implements BasketReferenceInformation {
		private final BasketName basketName;
		private final List<? extends BasketId> basketId;
		private final ReferencePool referencePool;
		private final Integer nthToDefault;
		private final Integer mthToDefault;
		private final Tranche tranche;
		
		protected BasketReferenceInformationImpl(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			this.basketName = ofNullable(builder.getBasketName()).map(f->f.build()).orElse(null);
			this.basketId = ofNullable(builder.getBasketId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.referencePool = ofNullable(builder.getReferencePool()).map(f->f.build()).orElse(null);
			this.nthToDefault = builder.getNthToDefault();
			this.mthToDefault = builder.getMthToDefault();
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketName")
		public BasketName getBasketName() {
			return basketName;
		}
		
		@Override
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketId")
		public List<? extends BasketId> getBasketId() {
			return basketId;
		}
		
		@Override
		@RosettaAttribute("referencePool")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referencePool")
		public ReferencePool getReferencePool() {
			return referencePool;
		}
		
		@Override
		@RosettaAttribute("nthToDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nthToDefault")
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		@RosettaAttribute("mthToDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mthToDefault")
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			BasketReferenceInformation.BasketReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketReferenceInformation.BasketReferenceInformationBuilder builder) {
			ofNullable(getBasketName()).ifPresent(builder::setBasketName);
			ofNullable(getBasketId()).ifPresent(builder::setBasketId);
			ofNullable(getReferencePool()).ifPresent(builder::setReferencePool);
			ofNullable(getNthToDefault()).ifPresent(builder::setNthToDefault);
			ofNullable(getMthToDefault()).ifPresent(builder::setMthToDefault);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformation {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"referencePool=" + this.referencePool + ", " +
				"nthToDefault=" + this.nthToDefault + ", " +
				"mthToDefault=" + this.mthToDefault + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketReferenceInformation  ***********************/
	class BasketReferenceInformationBuilderImpl implements BasketReferenceInformation.BasketReferenceInformationBuilder {
	
		protected BasketName.BasketNameBuilder basketName;
		protected List<BasketId.BasketIdBuilder> basketId = new ArrayList<>();
		protected ReferencePool.ReferencePoolBuilder referencePool;
		protected Integer nthToDefault;
		protected Integer mthToDefault;
		protected Tranche.TrancheBuilder tranche;
		
		@Override
		@RosettaAttribute("basketName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketName")
		public BasketName.BasketNameBuilder getBasketName() {
			return basketName;
		}
		
		@Override
		public BasketName.BasketNameBuilder getOrCreateBasketName() {
			BasketName.BasketNameBuilder result;
			if (basketName!=null) {
				result = basketName;
			}
			else {
				result = basketName = BasketName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketId")
		public List<? extends BasketId.BasketIdBuilder> getBasketId() {
			return basketId;
		}
		
		@Override
		public BasketId.BasketIdBuilder getOrCreateBasketId(int index) {
			if (basketId==null) {
				this.basketId = new ArrayList<>();
			}
			return getIndex(basketId, index, () -> {
						BasketId.BasketIdBuilder newBasketId = BasketId.builder();
						return newBasketId;
					});
		}
		
		@Override
		@RosettaAttribute("referencePool")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referencePool")
		public ReferencePool.ReferencePoolBuilder getReferencePool() {
			return referencePool;
		}
		
		@Override
		public ReferencePool.ReferencePoolBuilder getOrCreateReferencePool() {
			ReferencePool.ReferencePoolBuilder result;
			if (referencePool!=null) {
				result = referencePool;
			}
			else {
				result = referencePool = ReferencePool.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nthToDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nthToDefault")
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		@RosettaAttribute("mthToDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mthToDefault")
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("basketName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketName")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketName(BasketName _basketName) {
			this.basketName = _basketName == null ? null : _basketName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketId")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(BasketId _basketId) {
			if (_basketId != null) {
				this.basketId.add(_basketId.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(BasketId _basketId, int idx) {
			getIndex(this.basketId, idx, () -> _basketId.toBuilder());
			return this;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder addBasketId(List<? extends BasketId> basketIds) {
			if (basketIds != null) {
				for (final BasketId toAdd : basketIds) {
					this.basketId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketId")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setBasketId(List<? extends BasketId> basketIds) {
			if (basketIds == null) {
				this.basketId = new ArrayList<>();
			} else {
				this.basketId = basketIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("referencePool")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referencePool")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setReferencePool(ReferencePool _referencePool) {
			this.referencePool = _referencePool == null ? null : _referencePool.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nthToDefault")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nthToDefault")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setNthToDefault(Integer _nthToDefault) {
			this.nthToDefault = _nthToDefault == null ? null : _nthToDefault;
			return this;
		}
		
		@RosettaAttribute("mthToDefault")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mthToDefault")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setMthToDefault(Integer _mthToDefault) {
			this.mthToDefault = _mthToDefault == null ? null : _mthToDefault;
			return this;
		}
		
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tranche")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder setTranche(Tranche _tranche) {
			this.tranche = _tranche == null ? null : _tranche.toBuilder();
			return this;
		}
		
		@Override
		public BasketReferenceInformation build() {
			return new BasketReferenceInformation.BasketReferenceInformationImpl(this);
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder prune() {
			if (basketName!=null && !basketName.prune().hasData()) basketName = null;
			basketId = basketId.stream().filter(b->b!=null).<BasketId.BasketIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (referencePool!=null && !referencePool.prune().hasData()) referencePool = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketName()!=null && getBasketName().hasData()) return true;
			if (getBasketId()!=null && getBasketId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReferencePool()!=null && getReferencePool().hasData()) return true;
			if (getNthToDefault()!=null) return true;
			if (getMthToDefault()!=null) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketReferenceInformation.BasketReferenceInformationBuilder o = (BasketReferenceInformation.BasketReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getBasketName(), o.getBasketName(), this::setBasketName);
			merger.mergeRosetta(getBasketId(), o.getBasketId(), this::getOrCreateBasketId);
			merger.mergeRosetta(getReferencePool(), o.getReferencePool(), this::setReferencePool);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			
			merger.mergeBasic(getNthToDefault(), o.getNthToDefault(), this::setNthToDefault);
			merger.mergeBasic(getMthToDefault(), o.getMthToDefault(), this::setMthToDefault);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(referencePool, _that.getReferencePool())) return false;
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (referencePool != null ? referencePool.hashCode() : 0);
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformationBuilder {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"referencePool=" + this.referencePool + ", " +
				"nthToDefault=" + this.nthToDefault + ", " +
				"mthToDefault=" + this.mthToDefault + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}
}
