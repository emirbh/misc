package iso20022.auth030.hkma.dtcc;

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
import com.rosetta.model.lib.records.Date;
import iso20022.auth030.hkma.dtcc.meta.Schedule4__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates the unadjusted effective and end date of the schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="Schedule4__1", builder=Schedule4__1.Schedule4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Schedule4__1", model="iso20022", builder=Schedule4__1.Schedule4__1BuilderImpl.class, version="${project.version}")
public interface Schedule4__1 extends RosettaModelObject {

	Schedule4__1Meta metaData = new Schedule4__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the unadjusted date at which obligations under the  derivative transaction come into effect, as included in the confirmation.
	 */
	Date getUadjstdFctvDt();
	/**
	 * Indicates the end date agreed in the derivative transaction without adjustment.
	 */
	Date getUadjstdEndDt();
	/**
	 * Specifies the predetermined price at which the owner of the option can buy or sell the underlying instrument.  Usage: For foreign exchange options, specifies the exchange rate at which the option can be exercised as the rate of exchange from converting the unit currency into the quoted currency. For volatility and variance swaps, specify the volatility strike price.
	 */
	SecuritiesTransactionPrice17Choice__2 getPric();

	/*********************** Build Methods  ***********************/
	Schedule4__1 build();
	
	Schedule4__1.Schedule4__1Builder toBuilder();
	
	static Schedule4__1.Schedule4__1Builder builder() {
		return new Schedule4__1.Schedule4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Schedule4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Schedule4__1> getType() {
		return Schedule4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
		processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
		processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__2.class, getPric());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Schedule4__1Builder extends Schedule4__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder getOrCreatePric();
		@Override
		SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder getPric();
		Schedule4__1.Schedule4__1Builder setUadjstdFctvDt(Date uadjstdFctvDt);
		Schedule4__1.Schedule4__1Builder setUadjstdEndDt(Date uadjstdEndDt);
		Schedule4__1.Schedule4__1Builder setPric(SecuritiesTransactionPrice17Choice__2 pric);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
			processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
			processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder.class, getPric());
		}
		

		Schedule4__1.Schedule4__1Builder prune();
	}

	/*********************** Immutable Implementation of Schedule4__1  ***********************/
	class Schedule4__1Impl implements Schedule4__1 {
		private final Date uadjstdFctvDt;
		private final Date uadjstdEndDt;
		private final SecuritiesTransactionPrice17Choice__2 pric;
		
		protected Schedule4__1Impl(Schedule4__1.Schedule4__1Builder builder) {
			this.uadjstdFctvDt = builder.getUadjstdFctvDt();
			this.uadjstdEndDt = builder.getUadjstdEndDt();
			this.pric = ofNullable(builder.getPric()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		public Date getUadjstdFctvDt() {
			return uadjstdFctvDt;
		}
		
		@Override
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uadjstdEndDt")
		public Date getUadjstdEndDt() {
			return uadjstdEndDt;
		}
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__2 getPric() {
			return pric;
		}
		
		@Override
		public Schedule4__1 build() {
			return this;
		}
		
		@Override
		public Schedule4__1.Schedule4__1Builder toBuilder() {
			Schedule4__1.Schedule4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Schedule4__1.Schedule4__1Builder builder) {
			ofNullable(getUadjstdFctvDt()).ifPresent(builder::setUadjstdFctvDt);
			ofNullable(getUadjstdEndDt()).ifPresent(builder::setUadjstdEndDt);
			ofNullable(getPric()).ifPresent(builder::setPric);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule4__1 _that = getType().cast(o);
		
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule4__1 {" +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt + ", " +
				"pric=" + this.pric +
			'}';
		}
	}

	/*********************** Builder Implementation of Schedule4__1  ***********************/
	class Schedule4__1BuilderImpl implements Schedule4__1.Schedule4__1Builder {
	
		protected Date uadjstdFctvDt;
		protected Date uadjstdEndDt;
		protected SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder pric;
		
		@Override
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		public Date getUadjstdFctvDt() {
			return uadjstdFctvDt;
		}
		
		@Override
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uadjstdEndDt")
		public Date getUadjstdEndDt() {
			return uadjstdEndDt;
		}
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder getPric() {
			return pric;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder getOrCreatePric() {
			SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder result;
			if (pric!=null) {
				result = pric;
			}
			else {
				result = pric = SecuritiesTransactionPrice17Choice__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		@Override
		public Schedule4__1.Schedule4__1Builder setUadjstdFctvDt(Date _uadjstdFctvDt) {
			this.uadjstdFctvDt = _uadjstdFctvDt == null ? null : _uadjstdFctvDt;
			return this;
		}
		
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uadjstdEndDt")
		@Override
		public Schedule4__1.Schedule4__1Builder setUadjstdEndDt(Date _uadjstdEndDt) {
			this.uadjstdEndDt = _uadjstdEndDt == null ? null : _uadjstdEndDt;
			return this;
		}
		
		@RosettaAttribute("pric")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pric")
		@Override
		public Schedule4__1.Schedule4__1Builder setPric(SecuritiesTransactionPrice17Choice__2 _pric) {
			this.pric = _pric == null ? null : _pric.toBuilder();
			return this;
		}
		
		@Override
		public Schedule4__1 build() {
			return new Schedule4__1.Schedule4__1Impl(this);
		}
		
		@Override
		public Schedule4__1.Schedule4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule4__1.Schedule4__1Builder prune() {
			if (pric!=null && !pric.prune().hasData()) pric = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUadjstdFctvDt()!=null) return true;
			if (getUadjstdEndDt()!=null) return true;
			if (getPric()!=null && getPric().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule4__1.Schedule4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Schedule4__1.Schedule4__1Builder o = (Schedule4__1.Schedule4__1Builder) other;
			
			merger.mergeRosetta(getPric(), o.getPric(), this::setPric);
			
			merger.mergeBasic(getUadjstdFctvDt(), o.getUadjstdFctvDt(), this::setUadjstdFctvDt);
			merger.mergeBasic(getUadjstdEndDt(), o.getUadjstdEndDt(), this::setUadjstdEndDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule4__1 _that = getType().cast(o);
		
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule4__1Builder {" +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt + ", " +
				"pric=" + this.pric +
			'}';
		}
	}
}
