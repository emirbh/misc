package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.MakeWholeProvisionsMeta;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to hold early exercise provisions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to hold early exercise provisions.
 *
 */
@RosettaDataType(value="MakeWholeProvisions", builder=MakeWholeProvisions.MakeWholeProvisionsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MakeWholeProvisions", model="fpml", builder=MakeWholeProvisions.MakeWholeProvisionsBuilderImpl.class, version="2.1.1")
public interface MakeWholeProvisions extends RosettaModelObject {

	MakeWholeProvisionsMeta metaData = new MakeWholeProvisionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date through which option can not be exercised without penalty.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date through which option can not be exercised without penalty.
	 *
	 */
	ZonedDateTime getMakeWholeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Spread used if exercised before make whole date. Early termination penalty. Expressed in bp, e.g. 25 bp.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Spread used if exercised before make whole date. Early termination penalty. Expressed in bp, e.g. 25 bp.
	 *
	 */
	BigDecimal getRecallSpread();

	/*********************** Build Methods  ***********************/
	MakeWholeProvisions build();
	
	MakeWholeProvisions.MakeWholeProvisionsBuilder toBuilder();
	
	static MakeWholeProvisions.MakeWholeProvisionsBuilder builder() {
		return new MakeWholeProvisions.MakeWholeProvisionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MakeWholeProvisions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MakeWholeProvisions> getType() {
		return MakeWholeProvisions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("makeWholeDate"), ZonedDateTime.class, getMakeWholeDate(), this);
		processor.processBasic(path.newSubPath("recallSpread"), BigDecimal.class, getRecallSpread(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MakeWholeProvisionsBuilder extends MakeWholeProvisions, RosettaModelObjectBuilder {
		MakeWholeProvisions.MakeWholeProvisionsBuilder setMakeWholeDate(ZonedDateTime makeWholeDate);
		MakeWholeProvisions.MakeWholeProvisionsBuilder setRecallSpread(BigDecimal recallSpread);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("makeWholeDate"), ZonedDateTime.class, getMakeWholeDate(), this);
			processor.processBasic(path.newSubPath("recallSpread"), BigDecimal.class, getRecallSpread(), this);
		}
		

		MakeWholeProvisions.MakeWholeProvisionsBuilder prune();
	}

	/*********************** Immutable Implementation of MakeWholeProvisions  ***********************/
	class MakeWholeProvisionsImpl implements MakeWholeProvisions {
		private final ZonedDateTime makeWholeDate;
		private final BigDecimal recallSpread;
		
		protected MakeWholeProvisionsImpl(MakeWholeProvisions.MakeWholeProvisionsBuilder builder) {
			this.makeWholeDate = builder.getMakeWholeDate();
			this.recallSpread = builder.getRecallSpread();
		}
		
		@Override
		@RosettaAttribute("makeWholeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("makeWholeDate")
		public ZonedDateTime getMakeWholeDate() {
			return makeWholeDate;
		}
		
		@Override
		@RosettaAttribute("recallSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recallSpread")
		public BigDecimal getRecallSpread() {
			return recallSpread;
		}
		
		@Override
		public MakeWholeProvisions build() {
			return this;
		}
		
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder toBuilder() {
			MakeWholeProvisions.MakeWholeProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MakeWholeProvisions.MakeWholeProvisionsBuilder builder) {
			ofNullable(getMakeWholeDate()).ifPresent(builder::setMakeWholeDate);
			ofNullable(getRecallSpread()).ifPresent(builder::setRecallSpread);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MakeWholeProvisions _that = getType().cast(o);
		
			if (!Objects.equals(makeWholeDate, _that.getMakeWholeDate())) return false;
			if (!Objects.equals(recallSpread, _that.getRecallSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (makeWholeDate != null ? makeWholeDate.hashCode() : 0);
			_result = 31 * _result + (recallSpread != null ? recallSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeProvisions {" +
				"makeWholeDate=" + this.makeWholeDate + ", " +
				"recallSpread=" + this.recallSpread +
			'}';
		}
	}

	/*********************** Builder Implementation of MakeWholeProvisions  ***********************/
	class MakeWholeProvisionsBuilderImpl implements MakeWholeProvisions.MakeWholeProvisionsBuilder {
	
		protected ZonedDateTime makeWholeDate;
		protected BigDecimal recallSpread;
		
		@Override
		@RosettaAttribute("makeWholeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("makeWholeDate")
		public ZonedDateTime getMakeWholeDate() {
			return makeWholeDate;
		}
		
		@Override
		@RosettaAttribute("recallSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recallSpread")
		public BigDecimal getRecallSpread() {
			return recallSpread;
		}
		
		@RosettaAttribute("makeWholeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("makeWholeDate")
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder setMakeWholeDate(ZonedDateTime _makeWholeDate) {
			this.makeWholeDate = _makeWholeDate == null ? null : _makeWholeDate;
			return this;
		}
		
		@RosettaAttribute("recallSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recallSpread")
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder setRecallSpread(BigDecimal _recallSpread) {
			this.recallSpread = _recallSpread == null ? null : _recallSpread;
			return this;
		}
		
		@Override
		public MakeWholeProvisions build() {
			return new MakeWholeProvisions.MakeWholeProvisionsImpl(this);
		}
		
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMakeWholeDate()!=null) return true;
			if (getRecallSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MakeWholeProvisions.MakeWholeProvisionsBuilder o = (MakeWholeProvisions.MakeWholeProvisionsBuilder) other;
			
			
			merger.mergeBasic(getMakeWholeDate(), o.getMakeWholeDate(), this::setMakeWholeDate);
			merger.mergeBasic(getRecallSpread(), o.getRecallSpread(), this::setRecallSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MakeWholeProvisions _that = getType().cast(o);
		
			if (!Objects.equals(makeWholeDate, _that.getMakeWholeDate())) return false;
			if (!Objects.equals(recallSpread, _that.getRecallSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (makeWholeDate != null ? makeWholeDate.hashCode() : 0);
			_result = 31 * _result + (recallSpread != null ? recallSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MakeWholeProvisionsBuilder {" +
				"makeWholeDate=" + this.makeWholeDate + ", " +
				"recallSpread=" + this.recallSpread +
			'}';
		}
	}
}
