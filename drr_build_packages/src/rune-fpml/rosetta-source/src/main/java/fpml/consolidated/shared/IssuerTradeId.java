package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.shared.meta.IssuerTradeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A complex type for a two part identifier such as a USI.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type for a two part identifier such as a USI.
 *
 */
@RosettaDataType(value="IssuerTradeId", builder=IssuerTradeId.IssuerTradeIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IssuerTradeId", model="fpml", builder=IssuerTradeId.IssuerTradeIdBuilderImpl.class, version="2.1.1")
public interface IssuerTradeId extends RosettaModelObject {

	IssuerTradeIdMeta metaData = new IssuerTradeIdMeta();

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
	IssuerId getIssuer();
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
	TradeId getTradeId();

	/*********************** Build Methods  ***********************/
	IssuerTradeId build();
	
	IssuerTradeId.IssuerTradeIdBuilder toBuilder();
	
	static IssuerTradeId.IssuerTradeIdBuilder builder() {
		return new IssuerTradeId.IssuerTradeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IssuerTradeId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IssuerTradeId> getType() {
		return IssuerTradeId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IssuerTradeIdBuilder extends IssuerTradeId, RosettaModelObjectBuilder {
		IssuerId.IssuerIdBuilder getOrCreateIssuer();
		@Override
		IssuerId.IssuerIdBuilder getIssuer();
		TradeId.TradeIdBuilder getOrCreateTradeId();
		@Override
		TradeId.TradeIdBuilder getTradeId();
		IssuerTradeId.IssuerTradeIdBuilder setIssuer(IssuerId issuer);
		IssuerTradeId.IssuerTradeIdBuilder setTradeId(TradeId tradeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
		}
		

		IssuerTradeId.IssuerTradeIdBuilder prune();
	}

	/*********************** Immutable Implementation of IssuerTradeId  ***********************/
	class IssuerTradeIdImpl implements IssuerTradeId {
		private final IssuerId issuer;
		private final TradeId tradeId;
		
		protected IssuerTradeIdImpl(IssuerTradeId.IssuerTradeIdBuilder builder) {
			this.issuer = ofNullable(builder.getIssuer()).map(f->f.build()).orElse(null);
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("issuer")
		public IssuerId getIssuer() {
			return issuer;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
		}
		
		@Override
		public IssuerTradeId build() {
			return this;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder toBuilder() {
			IssuerTradeId.IssuerTradeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerTradeId.IssuerTradeIdBuilder builder) {
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeId _that = getType().cast(o);
		
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeId {" +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId +
			'}';
		}
	}

	/*********************** Builder Implementation of IssuerTradeId  ***********************/
	class IssuerTradeIdBuilderImpl implements IssuerTradeId.IssuerTradeIdBuilder {
	
		protected IssuerId.IssuerIdBuilder issuer;
		protected TradeId.TradeIdBuilder tradeId;
		
		@Override
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("issuer")
		public IssuerId.IssuerIdBuilder getIssuer() {
			return issuer;
		}
		
		@Override
		public IssuerId.IssuerIdBuilder getOrCreateIssuer() {
			IssuerId.IssuerIdBuilder result;
			if (issuer!=null) {
				result = issuer;
			}
			else {
				result = issuer = IssuerId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeId")
		public TradeId.TradeIdBuilder getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId() {
			TradeId.TradeIdBuilder result;
			if (tradeId!=null) {
				result = tradeId;
			}
			else {
				result = tradeId = TradeId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("issuer")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeId")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@Override
		public IssuerTradeId build() {
			return new IssuerTradeId.IssuerTradeIdImpl(this);
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder prune() {
			if (issuer!=null && !issuer.prune().hasData()) issuer = null;
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuer()!=null && getIssuer().hasData()) return true;
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerTradeId.IssuerTradeIdBuilder o = (IssuerTradeId.IssuerTradeIdBuilder) other;
			
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::setIssuer);
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeId _that = getType().cast(o);
		
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeIdBuilder {" +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId +
			'}';
		}
	}
}
