package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.StrikeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing a single cap or floor rate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a single cap or floor rate.
 *
 */
@RosettaDataType(value="Strike", builder=Strike.StrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Strike", model="fpml", builder=Strike.StrikeBuilderImpl.class, version="2.1.1")
public interface Strike extends RosettaModelObject {

	StrikeMeta metaData = new StrikeMeta();

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
	 * Provision The rate for a cap or floor.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate for a cap or floor.
	 *
	 */
	BigDecimal getStrikeRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The buyer of the option
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The buyer of the option
	 *
	 */
	IdentifiedPayerReceiver getBuyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party that has sold.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party that has sold.
	 *
	 */
	IdentifiedPayerReceiver getSeller();

	/*********************** Build Methods  ***********************/
	Strike build();
	
	Strike.StrikeBuilder toBuilder();
	
	static Strike.StrikeBuilder builder() {
		return new Strike.StrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Strike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Strike> getType() {
		return Strike.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("strikeRate"), BigDecimal.class, getStrikeRate(), this);
		processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.class, getBuyer());
		processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.class, getSeller());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrikeBuilder extends Strike, RosettaModelObjectBuilder {
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer();
		@Override
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller();
		@Override
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller();
		Strike.StrikeBuilder setId(String id);
		Strike.StrikeBuilder setStrikeRate(BigDecimal strikeRate);
		Strike.StrikeBuilder setBuyer(IdentifiedPayerReceiver buyer);
		Strike.StrikeBuilder setSeller(IdentifiedPayerReceiver seller);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("strikeRate"), BigDecimal.class, getStrikeRate(), this);
			processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getBuyer());
			processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getSeller());
		}
		

		Strike.StrikeBuilder prune();
	}

	/*********************** Immutable Implementation of Strike  ***********************/
	class StrikeImpl implements Strike {
		private final String id;
		private final BigDecimal strikeRate;
		private final IdentifiedPayerReceiver buyer;
		private final IdentifiedPayerReceiver seller;
		
		protected StrikeImpl(Strike.StrikeBuilder builder) {
			this.id = builder.getId();
			this.strikeRate = builder.getStrikeRate();
			this.buyer = ofNullable(builder.getBuyer()).map(f->f.build()).orElse(null);
			this.seller = ofNullable(builder.getSeller()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("strikeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeRate")
		public BigDecimal getStrikeRate() {
			return strikeRate;
		}
		
		@Override
		@RosettaAttribute("buyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyer")
		public IdentifiedPayerReceiver getBuyer() {
			return buyer;
		}
		
		@Override
		@RosettaAttribute("seller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seller")
		public IdentifiedPayerReceiver getSeller() {
			return seller;
		}
		
		@Override
		public Strike build() {
			return this;
		}
		
		@Override
		public Strike.StrikeBuilder toBuilder() {
			Strike.StrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Strike.StrikeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getStrikeRate()).ifPresent(builder::setStrikeRate);
			ofNullable(getBuyer()).ifPresent(builder::setBuyer);
			ofNullable(getSeller()).ifPresent(builder::setSeller);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Strike _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(strikeRate, _that.getStrikeRate())) return false;
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (strikeRate != null ? strikeRate.hashCode() : 0);
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Strike {" +
				"id=" + this.id + ", " +
				"strikeRate=" + this.strikeRate + ", " +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}';
		}
	}

	/*********************** Builder Implementation of Strike  ***********************/
	class StrikeBuilderImpl implements Strike.StrikeBuilder {
	
		protected String id;
		protected BigDecimal strikeRate;
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder buyer;
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder seller;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("strikeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeRate")
		public BigDecimal getStrikeRate() {
			return strikeRate;
		}
		
		@Override
		@RosettaAttribute("buyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyer")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer() {
			return buyer;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (buyer!=null) {
				result = buyer;
			}
			else {
				result = buyer = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seller")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller() {
			return seller;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (seller!=null) {
				result = seller;
			}
			else {
				result = seller = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Strike.StrikeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("strikeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeRate")
		@Override
		public Strike.StrikeBuilder setStrikeRate(BigDecimal _strikeRate) {
			this.strikeRate = _strikeRate == null ? null : _strikeRate;
			return this;
		}
		
		@RosettaAttribute("buyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyer")
		@Override
		public Strike.StrikeBuilder setBuyer(IdentifiedPayerReceiver _buyer) {
			this.buyer = _buyer == null ? null : _buyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seller")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seller")
		@Override
		public Strike.StrikeBuilder setSeller(IdentifiedPayerReceiver _seller) {
			this.seller = _seller == null ? null : _seller.toBuilder();
			return this;
		}
		
		@Override
		public Strike build() {
			return new Strike.StrikeImpl(this);
		}
		
		@Override
		public Strike.StrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strike.StrikeBuilder prune() {
			if (buyer!=null && !buyer.prune().hasData()) buyer = null;
			if (seller!=null && !seller.prune().hasData()) seller = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getStrikeRate()!=null) return true;
			if (getBuyer()!=null && getBuyer().hasData()) return true;
			if (getSeller()!=null && getSeller().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Strike.StrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Strike.StrikeBuilder o = (Strike.StrikeBuilder) other;
			
			merger.mergeRosetta(getBuyer(), o.getBuyer(), this::setBuyer);
			merger.mergeRosetta(getSeller(), o.getSeller(), this::setSeller);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getStrikeRate(), o.getStrikeRate(), this::setStrikeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Strike _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(strikeRate, _that.getStrikeRate())) return false;
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (strikeRate != null ? strikeRate.hashCode() : 0);
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeBuilder {" +
				"id=" + this.id + ", " +
				"strikeRate=" + this.strikeRate + ", " +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}';
		}
	}
}
