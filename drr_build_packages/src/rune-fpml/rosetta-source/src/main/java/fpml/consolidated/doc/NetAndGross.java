package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.NetAndGrossMeta;
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
 * Provision A structure including a net and/or a gross amount and possibly fees and commissions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure including a net and/or a gross amount and possibly fees and commissions.
 *
 */
@RosettaDataType(value="NetAndGross", builder=NetAndGross.NetAndGrossBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NetAndGross", model="fpml", builder=NetAndGross.NetAndGrossBuilderImpl.class, version="2.1.1")
public interface NetAndGross extends RosettaModelObject {

	NetAndGrossMeta metaData = new NetAndGrossMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Value excluding fees and commissions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Value excluding fees and commissions.
	 *
	 */
	BigDecimal getNet();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Value including fees and commissions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Value including fees and commissions.
	 *
	 */
	BigDecimal getGross();

	/*********************** Build Methods  ***********************/
	NetAndGross build();
	
	NetAndGross.NetAndGrossBuilder toBuilder();
	
	static NetAndGross.NetAndGrossBuilder builder() {
		return new NetAndGross.NetAndGrossBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NetAndGross> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NetAndGross> getType() {
		return NetAndGross.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("net"), BigDecimal.class, getNet(), this);
		processor.processBasic(path.newSubPath("gross"), BigDecimal.class, getGross(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NetAndGrossBuilder extends NetAndGross, RosettaModelObjectBuilder {
		NetAndGross.NetAndGrossBuilder setNet(BigDecimal net);
		NetAndGross.NetAndGrossBuilder setGross(BigDecimal gross);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("net"), BigDecimal.class, getNet(), this);
			processor.processBasic(path.newSubPath("gross"), BigDecimal.class, getGross(), this);
		}
		

		NetAndGross.NetAndGrossBuilder prune();
	}

	/*********************** Immutable Implementation of NetAndGross  ***********************/
	class NetAndGrossImpl implements NetAndGross {
		private final BigDecimal net;
		private final BigDecimal gross;
		
		protected NetAndGrossImpl(NetAndGross.NetAndGrossBuilder builder) {
			this.net = builder.getNet();
			this.gross = builder.getGross();
		}
		
		@Override
		@RosettaAttribute("net")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("net")
		public BigDecimal getNet() {
			return net;
		}
		
		@Override
		@RosettaAttribute("gross")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gross")
		public BigDecimal getGross() {
			return gross;
		}
		
		@Override
		public NetAndGross build() {
			return this;
		}
		
		@Override
		public NetAndGross.NetAndGrossBuilder toBuilder() {
			NetAndGross.NetAndGrossBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NetAndGross.NetAndGrossBuilder builder) {
			ofNullable(getNet()).ifPresent(builder::setNet);
			ofNullable(getGross()).ifPresent(builder::setGross);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndGross _that = getType().cast(o);
		
			if (!Objects.equals(net, _that.getNet())) return false;
			if (!Objects.equals(gross, _that.getGross())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (net != null ? net.hashCode() : 0);
			_result = 31 * _result + (gross != null ? gross.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndGross {" +
				"net=" + this.net + ", " +
				"gross=" + this.gross +
			'}';
		}
	}

	/*********************** Builder Implementation of NetAndGross  ***********************/
	class NetAndGrossBuilderImpl implements NetAndGross.NetAndGrossBuilder {
	
		protected BigDecimal net;
		protected BigDecimal gross;
		
		@Override
		@RosettaAttribute("net")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("net")
		public BigDecimal getNet() {
			return net;
		}
		
		@Override
		@RosettaAttribute("gross")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gross")
		public BigDecimal getGross() {
			return gross;
		}
		
		@RosettaAttribute("net")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("net")
		@Override
		public NetAndGross.NetAndGrossBuilder setNet(BigDecimal _net) {
			this.net = _net == null ? null : _net;
			return this;
		}
		
		@RosettaAttribute("gross")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("gross")
		@Override
		public NetAndGross.NetAndGrossBuilder setGross(BigDecimal _gross) {
			this.gross = _gross == null ? null : _gross;
			return this;
		}
		
		@Override
		public NetAndGross build() {
			return new NetAndGross.NetAndGrossImpl(this);
		}
		
		@Override
		public NetAndGross.NetAndGrossBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndGross.NetAndGrossBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNet()!=null) return true;
			if (getGross()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndGross.NetAndGrossBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NetAndGross.NetAndGrossBuilder o = (NetAndGross.NetAndGrossBuilder) other;
			
			
			merger.mergeBasic(getNet(), o.getNet(), this::setNet);
			merger.mergeBasic(getGross(), o.getGross(), this::setGross);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndGross _that = getType().cast(o);
		
			if (!Objects.equals(net, _that.getNet())) return false;
			if (!Objects.equals(gross, _that.getGross())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (net != null ? net.hashCode() : 0);
			_result = 31 * _result + (gross != null ? gross.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndGrossBuilder {" +
				"net=" + this.net + ", " +
				"gross=" + this.gross +
			'}';
		}
	}
}
