package iso20022.dtcc.rds.harmonized;

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
import com.rosetta.model.lib.records.Date;
import iso20022.dtcc.rds.harmonized.meta.CdeSchedule1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CdeSchedule1", builder=CdeSchedule1.CdeSchedule1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CdeSchedule1", model="iso20022", builder=CdeSchedule1.CdeSchedule1BuilderImpl.class, version="${project.version}")
public interface CdeSchedule1 extends RosettaModelObject {

	CdeSchedule1Meta metaData = new CdeSchedule1Meta();

	/*********************** Getter Methods  ***********************/
	Date getCdeEffectiveDateOfTheNotionalAmountLeg1();
	Date getCdeEndDateOfTheNotionalAmountLeg1();
	BigDecimal getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1();

	/*********************** Build Methods  ***********************/
	CdeSchedule1 build();
	
	CdeSchedule1.CdeSchedule1Builder toBuilder();
	
	static CdeSchedule1.CdeSchedule1Builder builder() {
		return new CdeSchedule1.CdeSchedule1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CdeSchedule1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CdeSchedule1> getType() {
		return CdeSchedule1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cdeEffectiveDateOfTheNotionalAmountLeg1"), Date.class, getCdeEffectiveDateOfTheNotionalAmountLeg1(), this);
		processor.processBasic(path.newSubPath("cdeEndDateOfTheNotionalAmountLeg1"), Date.class, getCdeEndDateOfTheNotionalAmountLeg1(), this);
		processor.processBasic(path.newSubPath("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1"), BigDecimal.class, getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CdeSchedule1Builder extends CdeSchedule1, RosettaModelObjectBuilder {
		CdeSchedule1.CdeSchedule1Builder setCdeEffectiveDateOfTheNotionalAmountLeg1(Date cdeEffectiveDateOfTheNotionalAmountLeg1);
		CdeSchedule1.CdeSchedule1Builder setCdeEndDateOfTheNotionalAmountLeg1(Date cdeEndDateOfTheNotionalAmountLeg1);
		CdeSchedule1.CdeSchedule1Builder setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(BigDecimal cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cdeEffectiveDateOfTheNotionalAmountLeg1"), Date.class, getCdeEffectiveDateOfTheNotionalAmountLeg1(), this);
			processor.processBasic(path.newSubPath("cdeEndDateOfTheNotionalAmountLeg1"), Date.class, getCdeEndDateOfTheNotionalAmountLeg1(), this);
			processor.processBasic(path.newSubPath("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1"), BigDecimal.class, getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(), this);
		}
		

		CdeSchedule1.CdeSchedule1Builder prune();
	}

	/*********************** Immutable Implementation of CdeSchedule1  ***********************/
	class CdeSchedule1Impl implements CdeSchedule1 {
		private final Date cdeEffectiveDateOfTheNotionalAmountLeg1;
		private final Date cdeEndDateOfTheNotionalAmountLeg1;
		private final BigDecimal cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1;
		
		protected CdeSchedule1Impl(CdeSchedule1.CdeSchedule1Builder builder) {
			this.cdeEffectiveDateOfTheNotionalAmountLeg1 = builder.getCdeEffectiveDateOfTheNotionalAmountLeg1();
			this.cdeEndDateOfTheNotionalAmountLeg1 = builder.getCdeEndDateOfTheNotionalAmountLeg1();
			this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1 = builder.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1();
		}
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfTheNotionalAmountLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEffectiveDateOfTheNotionalAmountLeg1")
		public Date getCdeEffectiveDateOfTheNotionalAmountLeg1() {
			return cdeEffectiveDateOfTheNotionalAmountLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfTheNotionalAmountLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEndDateOfTheNotionalAmountLeg1")
		public Date getCdeEndDateOfTheNotionalAmountLeg1() {
			return cdeEndDateOfTheNotionalAmountLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1")
		public BigDecimal getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1() {
			return cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1;
		}
		
		@Override
		public CdeSchedule1 build() {
			return this;
		}
		
		@Override
		public CdeSchedule1.CdeSchedule1Builder toBuilder() {
			CdeSchedule1.CdeSchedule1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CdeSchedule1.CdeSchedule1Builder builder) {
			ofNullable(getCdeEffectiveDateOfTheNotionalAmountLeg1()).ifPresent(builder::setCdeEffectiveDateOfTheNotionalAmountLeg1);
			ofNullable(getCdeEndDateOfTheNotionalAmountLeg1()).ifPresent(builder::setCdeEndDateOfTheNotionalAmountLeg1);
			ofNullable(getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1()).ifPresent(builder::setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdeSchedule1 _that = getType().cast(o);
		
			if (!Objects.equals(cdeEffectiveDateOfTheNotionalAmountLeg1, _that.getCdeEffectiveDateOfTheNotionalAmountLeg1())) return false;
			if (!Objects.equals(cdeEndDateOfTheNotionalAmountLeg1, _that.getCdeEndDateOfTheNotionalAmountLeg1())) return false;
			if (!Objects.equals(cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1, _that.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeEffectiveDateOfTheNotionalAmountLeg1 != null ? cdeEffectiveDateOfTheNotionalAmountLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfTheNotionalAmountLeg1 != null ? cdeEndDateOfTheNotionalAmountLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1 != null ? cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdeSchedule1 {" +
				"cdeEffectiveDateOfTheNotionalAmountLeg1=" + this.cdeEffectiveDateOfTheNotionalAmountLeg1 + ", " +
				"cdeEndDateOfTheNotionalAmountLeg1=" + this.cdeEndDateOfTheNotionalAmountLeg1 + ", " +
				"cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1=" + this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1 +
			'}';
		}
	}

	/*********************** Builder Implementation of CdeSchedule1  ***********************/
	class CdeSchedule1BuilderImpl implements CdeSchedule1.CdeSchedule1Builder {
	
		protected Date cdeEffectiveDateOfTheNotionalAmountLeg1;
		protected Date cdeEndDateOfTheNotionalAmountLeg1;
		protected BigDecimal cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1;
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfTheNotionalAmountLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEffectiveDateOfTheNotionalAmountLeg1")
		public Date getCdeEffectiveDateOfTheNotionalAmountLeg1() {
			return cdeEffectiveDateOfTheNotionalAmountLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfTheNotionalAmountLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEndDateOfTheNotionalAmountLeg1")
		public Date getCdeEndDateOfTheNotionalAmountLeg1() {
			return cdeEndDateOfTheNotionalAmountLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1")
		public BigDecimal getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1() {
			return cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1;
		}
		
		@RosettaAttribute("cdeEffectiveDateOfTheNotionalAmountLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeEffectiveDateOfTheNotionalAmountLeg1")
		@Override
		public CdeSchedule1.CdeSchedule1Builder setCdeEffectiveDateOfTheNotionalAmountLeg1(Date _cdeEffectiveDateOfTheNotionalAmountLeg1) {
			this.cdeEffectiveDateOfTheNotionalAmountLeg1 = _cdeEffectiveDateOfTheNotionalAmountLeg1 == null ? null : _cdeEffectiveDateOfTheNotionalAmountLeg1;
			return this;
		}
		
		@RosettaAttribute("cdeEndDateOfTheNotionalAmountLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeEndDateOfTheNotionalAmountLeg1")
		@Override
		public CdeSchedule1.CdeSchedule1Builder setCdeEndDateOfTheNotionalAmountLeg1(Date _cdeEndDateOfTheNotionalAmountLeg1) {
			this.cdeEndDateOfTheNotionalAmountLeg1 = _cdeEndDateOfTheNotionalAmountLeg1 == null ? null : _cdeEndDateOfTheNotionalAmountLeg1;
			return this;
		}
		
		@RosettaAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1")
		@Override
		public CdeSchedule1.CdeSchedule1Builder setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(BigDecimal _cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1) {
			this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1 = _cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1 == null ? null : _cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1;
			return this;
		}
		
		@Override
		public CdeSchedule1 build() {
			return new CdeSchedule1.CdeSchedule1Impl(this);
		}
		
		@Override
		public CdeSchedule1.CdeSchedule1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdeSchedule1.CdeSchedule1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCdeEffectiveDateOfTheNotionalAmountLeg1()!=null) return true;
			if (getCdeEndDateOfTheNotionalAmountLeg1()!=null) return true;
			if (getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdeSchedule1.CdeSchedule1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CdeSchedule1.CdeSchedule1Builder o = (CdeSchedule1.CdeSchedule1Builder) other;
			
			
			merger.mergeBasic(getCdeEffectiveDateOfTheNotionalAmountLeg1(), o.getCdeEffectiveDateOfTheNotionalAmountLeg1(), this::setCdeEffectiveDateOfTheNotionalAmountLeg1);
			merger.mergeBasic(getCdeEndDateOfTheNotionalAmountLeg1(), o.getCdeEndDateOfTheNotionalAmountLeg1(), this::setCdeEndDateOfTheNotionalAmountLeg1);
			merger.mergeBasic(getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(), o.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1(), this::setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdeSchedule1 _that = getType().cast(o);
		
			if (!Objects.equals(cdeEffectiveDateOfTheNotionalAmountLeg1, _that.getCdeEffectiveDateOfTheNotionalAmountLeg1())) return false;
			if (!Objects.equals(cdeEndDateOfTheNotionalAmountLeg1, _that.getCdeEndDateOfTheNotionalAmountLeg1())) return false;
			if (!Objects.equals(cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1, _that.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeEffectiveDateOfTheNotionalAmountLeg1 != null ? cdeEffectiveDateOfTheNotionalAmountLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfTheNotionalAmountLeg1 != null ? cdeEndDateOfTheNotionalAmountLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1 != null ? cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdeSchedule1Builder {" +
				"cdeEffectiveDateOfTheNotionalAmountLeg1=" + this.cdeEffectiveDateOfTheNotionalAmountLeg1 + ", " +
				"cdeEndDateOfTheNotionalAmountLeg1=" + this.cdeEndDateOfTheNotionalAmountLeg1 + ", " +
				"cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1=" + this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1 +
			'}';
		}
	}
}
