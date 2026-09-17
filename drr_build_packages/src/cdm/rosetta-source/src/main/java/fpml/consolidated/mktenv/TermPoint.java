package fpml.consolidated.mktenv;

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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.mktenv.meta.TermPointMeta;
import fpml.consolidated.riskdef.TimeDimension;
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
 * Provision A value point that can have a time dimension. Allows bid, mid, ask, and spread values to be represented.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A value point that can have a time dimension. Allows bid, mid, ask, and spread values to be represented.
 *
 */
@RosettaDataType(value="TermPoint", builder=TermPoint.TermPointBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TermPoint", model="fpml", builder=TermPoint.TermPointBuilderImpl.class, version="2.1.1")
public interface TermPoint extends RosettaModelObject {

	TermPointMeta metaData = new TermPointMeta();

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
	 * Provision The time dimension of the point (tenor and/or date)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time dimension of the point (tenor and/or date)
	 *
	 */
	TimeDimension getTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A price "bid" by a buyer for an asset, i.e. the price a buyer is willing to pay.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A price "bid" by a buyer for an asset, i.e. the price a buyer is willing to pay.
	 *
	 */
	BigDecimal getBid();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A price midway between the bid and the ask price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A price midway between the bid and the ask price.
	 *
	 */
	BigDecimal getMid();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A price "asked" by a seller for an asset, i.e. the price at which a seller is willing to sell.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A price "asked" by a seller for an asset, i.e. the price at which a seller is willing to sell.
	 *
	 */
	BigDecimal getAsk();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spread value can be used in conjunction with the "mid" value to define the bid and the ask value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spread value can be used in conjunction with the "mid" value to define the bid and the ask value.
	 *
	 */
	BigDecimal getSpreadValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional reference to an underlying asset that defines the meaning of the value, i.e. the product that the value corresponds to. For example, this could be a discount instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional reference to an underlying asset that defines the meaning of the value, i.e. the product that the value corresponds to. For example, this could be a discount instrument.
	 *
	 */
	AssetReference getDefinition();

	/*********************** Build Methods  ***********************/
	TermPoint build();
	
	TermPoint.TermPointBuilder toBuilder();
	
	static TermPoint.TermPointBuilder builder() {
		return new TermPoint.TermPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermPoint> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TermPoint> getType() {
		return TermPoint.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("term"), processor, TimeDimension.class, getTerm());
		processor.processBasic(path.newSubPath("bid"), BigDecimal.class, getBid(), this);
		processor.processBasic(path.newSubPath("mid"), BigDecimal.class, getMid(), this);
		processor.processBasic(path.newSubPath("ask"), BigDecimal.class, getAsk(), this);
		processor.processBasic(path.newSubPath("spreadValue"), BigDecimal.class, getSpreadValue(), this);
		processRosetta(path.newSubPath("definition"), processor, AssetReference.class, getDefinition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TermPointBuilder extends TermPoint, RosettaModelObjectBuilder {
		TimeDimension.TimeDimensionBuilder getOrCreateTerm();
		@Override
		TimeDimension.TimeDimensionBuilder getTerm();
		AssetReference.AssetReferenceBuilder getOrCreateDefinition();
		@Override
		AssetReference.AssetReferenceBuilder getDefinition();
		TermPoint.TermPointBuilder setId(String id);
		TermPoint.TermPointBuilder setTerm(TimeDimension term);
		TermPoint.TermPointBuilder setBid(BigDecimal bid);
		TermPoint.TermPointBuilder setMid(BigDecimal mid);
		TermPoint.TermPointBuilder setAsk(BigDecimal ask);
		TermPoint.TermPointBuilder setSpreadValue(BigDecimal spreadValue);
		TermPoint.TermPointBuilder setDefinition(AssetReference definition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("term"), processor, TimeDimension.TimeDimensionBuilder.class, getTerm());
			processor.processBasic(path.newSubPath("bid"), BigDecimal.class, getBid(), this);
			processor.processBasic(path.newSubPath("mid"), BigDecimal.class, getMid(), this);
			processor.processBasic(path.newSubPath("ask"), BigDecimal.class, getAsk(), this);
			processor.processBasic(path.newSubPath("spreadValue"), BigDecimal.class, getSpreadValue(), this);
			processRosetta(path.newSubPath("definition"), processor, AssetReference.AssetReferenceBuilder.class, getDefinition());
		}
		

		TermPoint.TermPointBuilder prune();
	}

	/*********************** Immutable Implementation of TermPoint  ***********************/
	class TermPointImpl implements TermPoint {
		private final String id;
		private final TimeDimension term;
		private final BigDecimal bid;
		private final BigDecimal mid;
		private final BigDecimal ask;
		private final BigDecimal spreadValue;
		private final AssetReference definition;
		
		protected TermPointImpl(TermPoint.TermPointBuilder builder) {
			this.id = builder.getId();
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.bid = builder.getBid();
			this.mid = builder.getMid();
			this.ask = builder.getAsk();
			this.spreadValue = builder.getSpreadValue();
			this.definition = ofNullable(builder.getDefinition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public TimeDimension getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("bid")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bid")
		public BigDecimal getBid() {
			return bid;
		}
		
		@Override
		@RosettaAttribute("mid")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mid")
		public BigDecimal getMid() {
			return mid;
		}
		
		@Override
		@RosettaAttribute("ask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ask")
		public BigDecimal getAsk() {
			return ask;
		}
		
		@Override
		@RosettaAttribute("spreadValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadValue")
		public BigDecimal getSpreadValue() {
			return spreadValue;
		}
		
		@Override
		@RosettaAttribute("definition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definition")
		public AssetReference getDefinition() {
			return definition;
		}
		
		@Override
		public TermPoint build() {
			return this;
		}
		
		@Override
		public TermPoint.TermPointBuilder toBuilder() {
			TermPoint.TermPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermPoint.TermPointBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getBid()).ifPresent(builder::setBid);
			ofNullable(getMid()).ifPresent(builder::setMid);
			ofNullable(getAsk()).ifPresent(builder::setAsk);
			ofNullable(getSpreadValue()).ifPresent(builder::setSpreadValue);
			ofNullable(getDefinition()).ifPresent(builder::setDefinition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermPoint _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(bid, _that.getBid())) return false;
			if (!Objects.equals(mid, _that.getMid())) return false;
			if (!Objects.equals(ask, _that.getAsk())) return false;
			if (!Objects.equals(spreadValue, _that.getSpreadValue())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (bid != null ? bid.hashCode() : 0);
			_result = 31 * _result + (mid != null ? mid.hashCode() : 0);
			_result = 31 * _result + (ask != null ? ask.hashCode() : 0);
			_result = 31 * _result + (spreadValue != null ? spreadValue.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermPoint {" +
				"id=" + this.id + ", " +
				"term=" + this.term + ", " +
				"bid=" + this.bid + ", " +
				"mid=" + this.mid + ", " +
				"ask=" + this.ask + ", " +
				"spreadValue=" + this.spreadValue + ", " +
				"definition=" + this.definition +
			'}';
		}
	}

	/*********************** Builder Implementation of TermPoint  ***********************/
	class TermPointBuilderImpl implements TermPoint.TermPointBuilder {
	
		protected String id;
		protected TimeDimension.TimeDimensionBuilder term;
		protected BigDecimal bid;
		protected BigDecimal mid;
		protected BigDecimal ask;
		protected BigDecimal spreadValue;
		protected AssetReference.AssetReferenceBuilder definition;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public TimeDimension.TimeDimensionBuilder getTerm() {
			return term;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateTerm() {
			TimeDimension.TimeDimensionBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bid")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bid")
		public BigDecimal getBid() {
			return bid;
		}
		
		@Override
		@RosettaAttribute("mid")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mid")
		public BigDecimal getMid() {
			return mid;
		}
		
		@Override
		@RosettaAttribute("ask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ask")
		public BigDecimal getAsk() {
			return ask;
		}
		
		@Override
		@RosettaAttribute("spreadValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadValue")
		public BigDecimal getSpreadValue() {
			return spreadValue;
		}
		
		@Override
		@RosettaAttribute("definition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definition")
		public AssetReference.AssetReferenceBuilder getDefinition() {
			return definition;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateDefinition() {
			AssetReference.AssetReferenceBuilder result;
			if (definition!=null) {
				result = definition;
			}
			else {
				result = definition = AssetReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TermPoint.TermPointBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("term")
		@Override
		public TermPoint.TermPointBuilder setTerm(TimeDimension _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bid")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bid")
		@Override
		public TermPoint.TermPointBuilder setBid(BigDecimal _bid) {
			this.bid = _bid == null ? null : _bid;
			return this;
		}
		
		@RosettaAttribute("mid")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mid")
		@Override
		public TermPoint.TermPointBuilder setMid(BigDecimal _mid) {
			this.mid = _mid == null ? null : _mid;
			return this;
		}
		
		@RosettaAttribute("ask")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ask")
		@Override
		public TermPoint.TermPointBuilder setAsk(BigDecimal _ask) {
			this.ask = _ask == null ? null : _ask;
			return this;
		}
		
		@RosettaAttribute("spreadValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadValue")
		@Override
		public TermPoint.TermPointBuilder setSpreadValue(BigDecimal _spreadValue) {
			this.spreadValue = _spreadValue == null ? null : _spreadValue;
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public TermPoint.TermPointBuilder setDefinition(AssetReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@Override
		public TermPoint build() {
			return new TermPoint.TermPointImpl(this);
		}
		
		@Override
		public TermPoint.TermPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermPoint.TermPointBuilder prune() {
			if (term!=null && !term.prune().hasData()) term = null;
			if (definition!=null && !definition.prune().hasData()) definition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getBid()!=null) return true;
			if (getMid()!=null) return true;
			if (getAsk()!=null) return true;
			if (getSpreadValue()!=null) return true;
			if (getDefinition()!=null && getDefinition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermPoint.TermPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TermPoint.TermPointBuilder o = (TermPoint.TermPointBuilder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getDefinition(), o.getDefinition(), this::setDefinition);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getBid(), o.getBid(), this::setBid);
			merger.mergeBasic(getMid(), o.getMid(), this::setMid);
			merger.mergeBasic(getAsk(), o.getAsk(), this::setAsk);
			merger.mergeBasic(getSpreadValue(), o.getSpreadValue(), this::setSpreadValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermPoint _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(bid, _that.getBid())) return false;
			if (!Objects.equals(mid, _that.getMid())) return false;
			if (!Objects.equals(ask, _that.getAsk())) return false;
			if (!Objects.equals(spreadValue, _that.getSpreadValue())) return false;
			if (!Objects.equals(definition, _that.getDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (bid != null ? bid.hashCode() : 0);
			_result = 31 * _result + (mid != null ? mid.hashCode() : 0);
			_result = 31 * _result + (ask != null ? ask.hashCode() : 0);
			_result = 31 * _result + (spreadValue != null ? spreadValue.hashCode() : 0);
			_result = 31 * _result + (definition != null ? definition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermPointBuilder {" +
				"id=" + this.id + ", " +
				"term=" + this.term + ", " +
				"bid=" + this.bid + ", " +
				"mid=" + this.mid + ", " +
				"ask=" + this.ask + ", " +
				"spreadValue=" + this.spreadValue + ", " +
				"definition=" + this.definition +
			'}';
		}
	}
}
