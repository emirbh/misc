package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.PTRREvent2__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information if contract results from a post trade risk reduction operation.
 * @version ${project.version}
 */
@RosettaDataType(value="PTRREvent2__1", builder=PTRREvent2__1.PTRREvent2__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PTRREvent2__1", model="iso20022", builder=PTRREvent2__1.PTRREvent2__1BuilderImpl.class, version="${project.version}")
public interface PTRREvent2__1 extends RosettaModelObject {

	PTRREvent2__1Meta metaData = new PTRREvent2__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicator of a type of a post trade risk reduction operation for the purpose of reporting.  Portfolio Compression without a third-party service provider: An arrangement to reduce risk in existing portfolios of trades using non-price forming trades mainly to reduce notional amount outstanding, the number of transactions or otherwise harmonise the terms, by wholly or partially terminate trades and commonly to replace the terminated derivatives with new replacement trades. Portfolio Compression with a third-party service provider or CCP: A post trade risk reduction service provided by a service provider or CCP to reduce risk in existing portfolios of trades using non-price forming trades mainly to reduce notional amount outstanding, the number of transactions or otherwise harmonise the terms, by wholly or partially terminate trades and commonly to replace the terminated derivatives with new replacement trades. Portfolio Rebalancing/Margin management: A PTRR service provided by a service provider to reduce risk in an existing portfolio of trades by adding new non-price forming trades and where no existing trades in the portfolio are terminated or replaced and the notional is increased rather than decreased. Other Portfolio post trade risk reduction services: A post trade risk reduction service provided by a service provider to reduce risk in existing portfolios of trades using non-price forming trades and where such service does not qualify as Portfolio Compression or Portfolio Rebalancing.
	 */
	RiskReductionService1Code__1 getTchnq();
	/**
	 * Identification of the post trade risk reduction service provider.
	 */
	OrganisationIdentification15Choice__1 getSvcPrvdr();

	/*********************** Build Methods  ***********************/
	PTRREvent2__1 build();
	
	PTRREvent2__1.PTRREvent2__1Builder toBuilder();
	
	static PTRREvent2__1.PTRREvent2__1Builder builder() {
		return new PTRREvent2__1.PTRREvent2__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PTRREvent2__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PTRREvent2__1> getType() {
		return PTRREvent2__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tchnq"), RiskReductionService1Code__1.class, getTchnq(), this);
		processRosetta(path.newSubPath("svcPrvdr"), processor, OrganisationIdentification15Choice__1.class, getSvcPrvdr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PTRREvent2__1Builder extends PTRREvent2__1, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateSvcPrvdr();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getSvcPrvdr();
		PTRREvent2__1.PTRREvent2__1Builder setTchnq(RiskReductionService1Code__1 tchnq);
		PTRREvent2__1.PTRREvent2__1Builder setSvcPrvdr(OrganisationIdentification15Choice__1 svcPrvdr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tchnq"), RiskReductionService1Code__1.class, getTchnq(), this);
			processRosetta(path.newSubPath("svcPrvdr"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getSvcPrvdr());
		}
		

		PTRREvent2__1.PTRREvent2__1Builder prune();
	}

	/*********************** Immutable Implementation of PTRREvent2__1  ***********************/
	class PTRREvent2__1Impl implements PTRREvent2__1 {
		private final RiskReductionService1Code__1 tchnq;
		private final OrganisationIdentification15Choice__1 svcPrvdr;
		
		protected PTRREvent2__1Impl(PTRREvent2__1.PTRREvent2__1Builder builder) {
			this.tchnq = builder.getTchnq();
			this.svcPrvdr = ofNullable(builder.getSvcPrvdr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tchnq")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tchnq")
		public RiskReductionService1Code__1 getTchnq() {
			return tchnq;
		}
		
		@Override
		@RosettaAttribute("svcPrvdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("svcPrvdr")
		public OrganisationIdentification15Choice__1 getSvcPrvdr() {
			return svcPrvdr;
		}
		
		@Override
		public PTRREvent2__1 build() {
			return this;
		}
		
		@Override
		public PTRREvent2__1.PTRREvent2__1Builder toBuilder() {
			PTRREvent2__1.PTRREvent2__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PTRREvent2__1.PTRREvent2__1Builder builder) {
			ofNullable(getTchnq()).ifPresent(builder::setTchnq);
			ofNullable(getSvcPrvdr()).ifPresent(builder::setSvcPrvdr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PTRREvent2__1 _that = getType().cast(o);
		
			if (!Objects.equals(tchnq, _that.getTchnq())) return false;
			if (!Objects.equals(svcPrvdr, _that.getSvcPrvdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tchnq != null ? tchnq.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (svcPrvdr != null ? svcPrvdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PTRREvent2__1 {" +
				"tchnq=" + this.tchnq + ", " +
				"svcPrvdr=" + this.svcPrvdr +
			'}';
		}
	}

	/*********************** Builder Implementation of PTRREvent2__1  ***********************/
	class PTRREvent2__1BuilderImpl implements PTRREvent2__1.PTRREvent2__1Builder {
	
		protected RiskReductionService1Code__1 tchnq;
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder svcPrvdr;
		
		@Override
		@RosettaAttribute("tchnq")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tchnq")
		public RiskReductionService1Code__1 getTchnq() {
			return tchnq;
		}
		
		@Override
		@RosettaAttribute("svcPrvdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("svcPrvdr")
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getSvcPrvdr() {
			return svcPrvdr;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateSvcPrvdr() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder result;
			if (svcPrvdr!=null) {
				result = svcPrvdr;
			}
			else {
				result = svcPrvdr = OrganisationIdentification15Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("tchnq")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tchnq")
		@Override
		public PTRREvent2__1.PTRREvent2__1Builder setTchnq(RiskReductionService1Code__1 _tchnq) {
			this.tchnq = _tchnq == null ? null : _tchnq;
			return this;
		}
		
		@RosettaAttribute("svcPrvdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("svcPrvdr")
		@Override
		public PTRREvent2__1.PTRREvent2__1Builder setSvcPrvdr(OrganisationIdentification15Choice__1 _svcPrvdr) {
			this.svcPrvdr = _svcPrvdr == null ? null : _svcPrvdr.toBuilder();
			return this;
		}
		
		@Override
		public PTRREvent2__1 build() {
			return new PTRREvent2__1.PTRREvent2__1Impl(this);
		}
		
		@Override
		public PTRREvent2__1.PTRREvent2__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PTRREvent2__1.PTRREvent2__1Builder prune() {
			if (svcPrvdr!=null && !svcPrvdr.prune().hasData()) svcPrvdr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTchnq()!=null) return true;
			if (getSvcPrvdr()!=null && getSvcPrvdr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PTRREvent2__1.PTRREvent2__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PTRREvent2__1.PTRREvent2__1Builder o = (PTRREvent2__1.PTRREvent2__1Builder) other;
			
			merger.mergeRosetta(getSvcPrvdr(), o.getSvcPrvdr(), this::setSvcPrvdr);
			
			merger.mergeBasic(getTchnq(), o.getTchnq(), this::setTchnq);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PTRREvent2__1 _that = getType().cast(o);
		
			if (!Objects.equals(tchnq, _that.getTchnq())) return false;
			if (!Objects.equals(svcPrvdr, _that.getSvcPrvdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tchnq != null ? tchnq.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (svcPrvdr != null ? svcPrvdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PTRREvent2__1Builder {" +
				"tchnq=" + this.tchnq + ", " +
				"svcPrvdr=" + this.svcPrvdr +
			'}';
		}
	}
}
