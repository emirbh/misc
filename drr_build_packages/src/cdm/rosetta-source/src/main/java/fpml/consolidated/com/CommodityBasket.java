package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityBasketMeta;
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
 * Provision Describes the swap's underlyer when it has multiple asset components.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes the swap's underlyer when it has multiple asset components.
 *
 */
@RosettaDataType(value="CommodityBasket", builder=CommodityBasket.CommodityBasketBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBasket", model="fpml", builder=CommodityBasket.CommodityBasketBuilderImpl.class, version="2.1.1")
public interface CommodityBasket extends RosettaModelObject {

	CommodityBasketMeta metaData = new CommodityBasketMeta();

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
	CommodityBasketByNotional getNotionalQuantityBasket();
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
	CommodityBasketByPercentage getNotionalAmountBasket();

	/*********************** Build Methods  ***********************/
	CommodityBasket build();
	
	CommodityBasket.CommodityBasketBuilder toBuilder();
	
	static CommodityBasket.CommodityBasketBuilder builder() {
		return new CommodityBasket.CommodityBasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasket> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBasket> getType() {
		return CommodityBasket.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketName"), processor, BasketName.class, getBasketName());
		processRosetta(path.newSubPath("basketId"), processor, BasketId.class, getBasketId());
		processRosetta(path.newSubPath("notionalQuantityBasket"), processor, CommodityBasketByNotional.class, getNotionalQuantityBasket());
		processRosetta(path.newSubPath("notionalAmountBasket"), processor, CommodityBasketByPercentage.class, getNotionalAmountBasket());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketBuilder extends CommodityBasket, RosettaModelObjectBuilder {
		BasketName.BasketNameBuilder getOrCreateBasketName();
		@Override
		BasketName.BasketNameBuilder getBasketName();
		BasketId.BasketIdBuilder getOrCreateBasketId(int index);
		@Override
		List<? extends BasketId.BasketIdBuilder> getBasketId();
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder getOrCreateNotionalQuantityBasket();
		@Override
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder getNotionalQuantityBasket();
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getOrCreateNotionalAmountBasket();
		@Override
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getNotionalAmountBasket();
		CommodityBasket.CommodityBasketBuilder setBasketName(BasketName basketName);
		CommodityBasket.CommodityBasketBuilder addBasketId(BasketId basketId);
		CommodityBasket.CommodityBasketBuilder addBasketId(BasketId basketId, int idx);
		CommodityBasket.CommodityBasketBuilder addBasketId(List<? extends BasketId> basketId);
		CommodityBasket.CommodityBasketBuilder setBasketId(List<? extends BasketId> basketId);
		CommodityBasket.CommodityBasketBuilder setNotionalQuantityBasket(CommodityBasketByNotional notionalQuantityBasket);
		CommodityBasket.CommodityBasketBuilder setNotionalAmountBasket(CommodityBasketByPercentage notionalAmountBasket);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketName"), processor, BasketName.BasketNameBuilder.class, getBasketName());
			processRosetta(path.newSubPath("basketId"), processor, BasketId.BasketIdBuilder.class, getBasketId());
			processRosetta(path.newSubPath("notionalQuantityBasket"), processor, CommodityBasketByNotional.CommodityBasketByNotionalBuilder.class, getNotionalQuantityBasket());
			processRosetta(path.newSubPath("notionalAmountBasket"), processor, CommodityBasketByPercentage.CommodityBasketByPercentageBuilder.class, getNotionalAmountBasket());
		}
		

		CommodityBasket.CommodityBasketBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasket  ***********************/
	class CommodityBasketImpl implements CommodityBasket {
		private final BasketName basketName;
		private final List<? extends BasketId> basketId;
		private final CommodityBasketByNotional notionalQuantityBasket;
		private final CommodityBasketByPercentage notionalAmountBasket;
		
		protected CommodityBasketImpl(CommodityBasket.CommodityBasketBuilder builder) {
			this.basketName = ofNullable(builder.getBasketName()).map(f->f.build()).orElse(null);
			this.basketId = ofNullable(builder.getBasketId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notionalQuantityBasket = ofNullable(builder.getNotionalQuantityBasket()).map(f->f.build()).orElse(null);
			this.notionalAmountBasket = ofNullable(builder.getNotionalAmountBasket()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("notionalQuantityBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantityBasket")
		public CommodityBasketByNotional getNotionalQuantityBasket() {
			return notionalQuantityBasket;
		}
		
		@Override
		@RosettaAttribute("notionalAmountBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountBasket")
		public CommodityBasketByPercentage getNotionalAmountBasket() {
			return notionalAmountBasket;
		}
		
		@Override
		public CommodityBasket build() {
			return this;
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder toBuilder() {
			CommodityBasket.CommodityBasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasket.CommodityBasketBuilder builder) {
			ofNullable(getBasketName()).ifPresent(builder::setBasketName);
			ofNullable(getBasketId()).ifPresent(builder::setBasketId);
			ofNullable(getNotionalQuantityBasket()).ifPresent(builder::setNotionalQuantityBasket);
			ofNullable(getNotionalAmountBasket()).ifPresent(builder::setNotionalAmountBasket);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasket _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(notionalQuantityBasket, _that.getNotionalQuantityBasket())) return false;
			if (!Objects.equals(notionalAmountBasket, _that.getNotionalAmountBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (notionalQuantityBasket != null ? notionalQuantityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmountBasket != null ? notionalAmountBasket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasket {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"notionalQuantityBasket=" + this.notionalQuantityBasket + ", " +
				"notionalAmountBasket=" + this.notionalAmountBasket +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBasket  ***********************/
	class CommodityBasketBuilderImpl implements CommodityBasket.CommodityBasketBuilder {
	
		protected BasketName.BasketNameBuilder basketName;
		protected List<BasketId.BasketIdBuilder> basketId = new ArrayList<>();
		protected CommodityBasketByNotional.CommodityBasketByNotionalBuilder notionalQuantityBasket;
		protected CommodityBasketByPercentage.CommodityBasketByPercentageBuilder notionalAmountBasket;
		
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
		@RosettaAttribute("notionalQuantityBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantityBasket")
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder getNotionalQuantityBasket() {
			return notionalQuantityBasket;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder getOrCreateNotionalQuantityBasket() {
			CommodityBasketByNotional.CommodityBasketByNotionalBuilder result;
			if (notionalQuantityBasket!=null) {
				result = notionalQuantityBasket;
			}
			else {
				result = notionalQuantityBasket = CommodityBasketByNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmountBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountBasket")
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getNotionalAmountBasket() {
			return notionalAmountBasket;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getOrCreateNotionalAmountBasket() {
			CommodityBasketByPercentage.CommodityBasketByPercentageBuilder result;
			if (notionalAmountBasket!=null) {
				result = notionalAmountBasket;
			}
			else {
				result = notionalAmountBasket = CommodityBasketByPercentage.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("basketName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketName")
		@Override
		public CommodityBasket.CommodityBasketBuilder setBasketName(BasketName _basketName) {
			this.basketName = _basketName == null ? null : _basketName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("basketId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketId")
		@Override
		public CommodityBasket.CommodityBasketBuilder addBasketId(BasketId _basketId) {
			if (_basketId != null) {
				this.basketId.add(_basketId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder addBasketId(BasketId _basketId, int idx) {
			getIndex(this.basketId, idx, () -> _basketId.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder addBasketId(List<? extends BasketId> basketIds) {
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
		public CommodityBasket.CommodityBasketBuilder setBasketId(List<? extends BasketId> basketIds) {
			if (basketIds == null) {
				this.basketId = new ArrayList<>();
			} else {
				this.basketId = basketIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notionalQuantityBasket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantityBasket")
		@Override
		public CommodityBasket.CommodityBasketBuilder setNotionalQuantityBasket(CommodityBasketByNotional _notionalQuantityBasket) {
			this.notionalQuantityBasket = _notionalQuantityBasket == null ? null : _notionalQuantityBasket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmountBasket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmountBasket")
		@Override
		public CommodityBasket.CommodityBasketBuilder setNotionalAmountBasket(CommodityBasketByPercentage _notionalAmountBasket) {
			this.notionalAmountBasket = _notionalAmountBasket == null ? null : _notionalAmountBasket.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasket build() {
			return new CommodityBasket.CommodityBasketImpl(this);
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasket.CommodityBasketBuilder prune() {
			if (basketName!=null && !basketName.prune().hasData()) basketName = null;
			basketId = basketId.stream().filter(b->b!=null).<BasketId.BasketIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (notionalQuantityBasket!=null && !notionalQuantityBasket.prune().hasData()) notionalQuantityBasket = null;
			if (notionalAmountBasket!=null && !notionalAmountBasket.prune().hasData()) notionalAmountBasket = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketName()!=null && getBasketName().hasData()) return true;
			if (getBasketId()!=null && getBasketId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotionalQuantityBasket()!=null && getNotionalQuantityBasket().hasData()) return true;
			if (getNotionalAmountBasket()!=null && getNotionalAmountBasket().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasket.CommodityBasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBasket.CommodityBasketBuilder o = (CommodityBasket.CommodityBasketBuilder) other;
			
			merger.mergeRosetta(getBasketName(), o.getBasketName(), this::setBasketName);
			merger.mergeRosetta(getBasketId(), o.getBasketId(), this::getOrCreateBasketId);
			merger.mergeRosetta(getNotionalQuantityBasket(), o.getNotionalQuantityBasket(), this::setNotionalQuantityBasket);
			merger.mergeRosetta(getNotionalAmountBasket(), o.getNotionalAmountBasket(), this::setNotionalAmountBasket);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasket _that = getType().cast(o);
		
			if (!Objects.equals(basketName, _that.getBasketName())) return false;
			if (!ListEquals.listEquals(basketId, _that.getBasketId())) return false;
			if (!Objects.equals(notionalQuantityBasket, _that.getNotionalQuantityBasket())) return false;
			if (!Objects.equals(notionalAmountBasket, _that.getNotionalAmountBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketName != null ? basketName.hashCode() : 0);
			_result = 31 * _result + (basketId != null ? basketId.hashCode() : 0);
			_result = 31 * _result + (notionalQuantityBasket != null ? notionalQuantityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmountBasket != null ? notionalAmountBasket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketBuilder {" +
				"basketName=" + this.basketName + ", " +
				"basketId=" + this.basketId + ", " +
				"notionalQuantityBasket=" + this.notionalQuantityBasket + ", " +
				"notionalAmountBasket=" + this.notionalAmountBasket +
			'}';
		}
	}
}
